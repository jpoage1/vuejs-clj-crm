(ns inmogr-budget.stats-by-role
  (:require [inmogr-budget.staff-by-role :refer [staff-by-role]]
            [inmogr-budget.employee-stat :refer [employee-stat]]))
(defn stats-by-role
  [staff role product-rate devs sdrs]
  (map
   (staff-by-role staff role)
   (fn [employee]
     (get
      (employee-stat employee product-rate devs sdrs)
      (get employee :role)))))