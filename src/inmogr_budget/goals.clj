(ns inmogr-budget.goals
  (:require 
            [inmogr-budget.data.labels  :refer [developer sdr manager]]
            [inmogr-budget.staff-by-role :refer [staff-by-role]]
            [inmogr-budget.all-config-stats :refer [all-config-stats]]
            [inmogr-budget.deals :refer [deals]]
            [inmogr-budget.profit :refer [profit] :reload true]
            [inmogr-budget.cost-per-employee :refer [cost-per-employee] :reload true]))
(defn g 
([config staff] (g config staff nil))
([config staff x]
    (let [{average-deal :average-deal
           prospect-to-lead :prospect-to-lead
           lead-to-qualified :lead-to-qualified
           qualified-to-sale :qualified-to-sale
           annual-revenue :annual-revenue} config
    sdr-commission (int 1)
    y (merge config {
        
        ;    -this is all wrong. we arent' going to say 
        ;    'we need this many deals to prospect ths many people'
        ;    but rather
        ;    'we need this many leads to get this many deals'

        ;   -revenue goal should be calculated by figuring out how much it costs
        ;   to be in business at the -mINI-mU-m
        :prospects #(Math/ceil (/
                                (g config staff 'leads')
                                prospect-to-lead))
        :leads #(Math/ceil (/
                           (g config staff 'conversions')
                           lead-to-qualified))
        :conversions #(Math/ceil (/
                                 (g config staff 'deals')
                                 qualified-to-sale))
        :deals #(Math/ceil (deals
                           (annual-revenue
                            average-deal)))
        :revenue-per-dev #(let [no-of-devs (count
                                            (staff-by-role staff developer))]
                            (/ annual-revenue
                               no-of-devs))
        :cost-per-manager #(cost-per-employee staff manager)
        :cost-per-dev  #(cost-per-employee staff developer)
        :cost-per-s-d-r #(* annual-revenue sdr-commission) ; calculate average commission rate
        :revenue-per-s-d-r #(let
                             [sdrs (staff-by-role staff sdr)]
                              (/
                               annual-revenue
                               (count sdrs)))
        :profit #(let [no-of-devs (count (staff-by-role staff developer))]
                    (let [expenses [(g config staff 'cost-per-manager')
                                    (*
                                     (g config staff 'cost-per-dev')
                                     no-of-devs)
                                    (g config staff 'cost-per-sdr')]]
                    (profit annual-revenue
                            expenses)))
    })]
    (if (not= x nil)
      (y x)
      y))))
(defn f [f]
  "Check if a function needs called"
  (if (clojure.test/function? f)
  (f) f))
(defn goals [config staff]
"Render goals"
    (get (map (fn [config] (fn [config]
                             (let [goals (g config staff)]
                               (map goals (fn [name]
                                              (assoc goals (get goals name))))
                               goals)
                             ))
              (all-config-stats config staff))
         config))