(ns inmogr-budget.weekly-wage
  (:require [inmogr-budget.weekly-revenue :refer [weekly-revenue]]))
(defn weekly-wage
  [employees employee deals average-deal helper]
  (helper employee
          (weekly-revenue employees employee deals average-deal)))