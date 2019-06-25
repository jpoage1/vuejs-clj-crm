(ns clj-crm.stats.goals
  (:require
   [clj-crm.data.labels  :refer [developer sdr manager]]
   [clojure.test :refer [function?]]
   [clj-crm.stats.staff-by-role :refer [staff-by-role]]
   [clj-crm.stats.all-config-stats :refer [all-config-stats]]
   [clj-crm.stats.deals :refer [deals]]
   [clj-crm.stats.profit :refer [profit]]
   [clj-crm.stats.cost-per-employee :refer [cost-per-employee]]
   ))
(defn g
  ([config staff] (g config staff nil))
  ([config staff goal-name]
   (let [{average-deal :average-deal
          prospect-to-lead :prospect-to-lead
          lead-to-qualified :lead-to-qualified
          qualified-to-sale :qualified-to-sale
          annual-revenue :annual-revenue} config
         sdr-commission (int 1)
         parsed-goals {;    -this is all wrong. we arent' going to say 
        ;    'we need this many deals to prospect ths many people'
        ;    but rather
        ;    'we need this many leads to get this many deals'
                       
        ;   -revenue goal should be calculated by figuring out how much it costs
        ;   to be in business at the -mINI-mU-m
                       :prospects #(Math/ceil (/
                                               (g config staff :leads)
                                               prospect-to-lead))
                       :leads #(Math/ceil (/
                                           (g config staff :conversions)
                                           lead-to-qualified))
                       :conversions #(Math/ceil (/
                                                 (g config staff :deals)
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
                       :cost-per-sdr #(annual-revenue sdr-commission) ; calculate average commission rate
                       :revenue-per-sdr #(let
                                          [sdrs (staff-by-role staff sdr)]
                                           (/
                                            annual-revenue
                                            (count sdrs)))
                       :profit #(let [no-of-devs (count (staff-by-role staff developer))
                                      expenses [(g config staff :cost-per-manager)
                                                (*
                                                 (g config staff :cost-per-dev)
                                                 no-of-devs)
                                                (g config staff :cost-per-sdr)]]
                                  (profit annual-revenue
                                          expenses))}
         company-goals (merge config parsed-goals)]
     (if (not= goal-name nil)
       (company-goals goal-name)
       company-goals))))

(defn render-function [f]
  "Check if a function needs called"
  (if (function? f)
    (f) f))
(defn render-goal [goals]
  (fn [goal]
    (let [goal-name (key goal)
          goal-function (val goal)]
      (assoc goals  goal-name (render-function goal-function)))))

(defn render-all-goals [config staff]
  (let [goals (g config staff)]
    (map (render-goal goals) goals)
    goals)) ;this is the return value and should be mutated

(defn render-all-configs [config staff]
  (fn [config] (render-all-goals config staff)))

(defn goals [config staff]
  (map (render-all-configs config staff))
  (all-config-stats config staff))