(ns js-budget-analyzer.annual-wage
  (:require [js-budget-analyzer.annual-revenue :refer [annual-revenue]]
            ))
(defn annual-wage
  [employees employee deals average-deal helper]

  (helper employee (annual-revenue employees employee deals average-deal)))