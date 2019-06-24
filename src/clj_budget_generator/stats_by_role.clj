(ns js-budget-analyzer.stats-by-role
  (:require [js-budget-analyzer.staff-by-role :refer [staff-by-role]]
            [js-budget-analyzer.employee-stat :refer [employee-stat]]
            ))
(defn stats-by-role
  [staff role product-rate devs sdrs]
  (map
   (fn [employee]
     (get
      (employee-stat employee product-rate devs sdrs)
      (get employee :role)))
   (staff-by-role staff role)))