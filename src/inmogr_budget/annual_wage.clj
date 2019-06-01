(ns inmogr-budget.annual-wage
  (:require [inmogr-budget.annual-revenue :refer [annual-revenue]]
            ))
(defn annual-wage
  [employees employee deals average-deal helper]
  (prn 'annual-wage helper)
  (helper employee (annual-revenue employees employee deals average-deal)))