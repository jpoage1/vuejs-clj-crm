(ns inmogr-budget.employee-stats
  (:require [inmogr-budget.data.labels :refer [developer sdr manager]]
            [inmogr-budget.employee-stat :refer [employee-stat] :reload true]
            [inmogr-budget.staff-by-role :refer [staff-by-role]]
            [inmogr-budget.deals :refer [deals]]))
(defn employee-stats
  [config staff]
  (let [{annual-revenue :annual-revenue
         average-deal :average-deal} config
        d (deals annual-revenue average-deal)
        employees {manager (staff-by-role staff manager)
                   developer (staff-by-role staff developer)
                   sdr (staff-by-role staff sdr)}]
    (map #(employee-stat config, employees, %1, d) staff)))