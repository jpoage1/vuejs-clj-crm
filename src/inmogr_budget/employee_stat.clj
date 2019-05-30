(ns inmogr-budget.employee-stat
  (:require [inmogr-budget.utilities.math :refer [evaluate]]
            [inmogr-budget.wage-helper :refer [wage-helper] :reload true]
            [inmogr-budget.weekly-wage :refer [weekly-wage] :reload true]
            [inmogr-budget.annual-revenue :refer [annual-revenue]]
            [inmogr-budget.annual-wage :refer [annual-wage] :reload true]
            [inmogr-budget.weekly-revenue :refer [weekly-revenue]]))



(defn stat
  [employees deals average-deal]
  (fn
    ([f e] (stat f e deals average-deal nil))
    ([f e h]
     (f employees e deals average-deal h))))


(defn employee-stat
[config employees employee deals]
  (let [employee-role (get employees :role)
        {employees-by-role (find employees employee-role)
         helper (wage-helper config employee-role)
         average-deal :average-deal} config]
    (merge employee {
                     :rate (evaluate (get employee :rate))
                     :weekly-revenue (stat 'weekly-revenue)
                     :weekly-wages (stat 'weekly-wage helper)
                     :annual-revenue (stat 'annual-revenue)
                     :annual-wages (stat annual-wage helper)
                     }
           )
)
)