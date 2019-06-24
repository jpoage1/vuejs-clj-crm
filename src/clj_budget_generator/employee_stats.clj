(ns js-budget-analyzer.employee-stats
  (:require [js-budget-analyzer.data.labels :refer [developer sdr manager]]
            [js-budget-analyzer.employee-stat :refer [employee-stat] :reload true]
            [js-budget-analyzer.staff-by-role :refer [staff-by-role]]
            [js-budget-analyzer.deals :refer [deals]]
	 [js-budget-analyzer.utilities.casting :refer [to-integer]]))
(defn employee-stats
  [config staff]
  (let [{annual-revenue :annual-revenue
         average-deal :average-deal} config
        d (deals annual-revenue average-deal)
        employees {manager (staff-by-role staff manager)
                   developer (staff-by-role staff developer)
                   sdr (staff-by-role staff sdr)}]
    (map (fn [employee]
           (let [employee-role (to-integer (get employee :role))
           						employees-by-role (get employees employee-role)]



             (employee-stat config employees-by-role employee d)))
         staff)))