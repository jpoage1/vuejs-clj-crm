(ns inmogr-budget.employee-stat
  (:require [inmogr-budget.utilities.math :refer [evaluate]]
            [inmogr-budget.wage-helper :refer [wage-helper] :reload true]
            [inmogr-budget.weekly-wage :refer [weekly-wage] :reload true]
            [inmogr-budget.annual-revenue :refer [annual-revenue]]
            [inmogr-budget.annual-wage :refer [annual-wage] :reload true]
            [inmogr-budget.weekly-revenue :refer [weekly-revenue]]
            ))
(defn get-stat
  [employees employee deals average-deal]
  (prn 'get-stat employees)
  (fn
    ([f] 
     (f employees employee deals average-deal))
    ([f h]
     (f employees employee deals average-deal h))))
(defn employee-stat
  [config employees employee deals]
  (prn 'employee-stat employees)
  (let [employee-role (get employee :role)
        helper (wage-helper config employee employee-role)
         {average-deal :average-deal} config
        stat (get-stat employees employee deals average-deal)]
        ;this can get cleaned up a bit, not enough recursion and lots of repeating
    (merge employee {:rate (evaluate (get employee :rate))
                     :weekly-revenue (stat weekly-revenue)
                     :weekly-wages (stat weekly-wage helper)
                     :annual-revenue (stat annual-revenue)
                     :annual-wages (stat annual-wage helper)
                     })))