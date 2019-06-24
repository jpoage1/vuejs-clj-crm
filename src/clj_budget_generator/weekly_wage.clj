(ns js-budget-analyzer.weekly-wage
  (:require [js-budget-analyzer.weekly-revenue :refer [weekly-revenue]]
            ))
(defn weekly-wage
  [employees employee deals average-deal helper]
  (helper employee
          (weekly-revenue employees employee deals average-deal)))