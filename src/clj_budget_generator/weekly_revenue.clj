(ns js-budget-analyzer.weekly-revenue
  (:require [js-budget-analyzer.annual-revenue :refer [annual-revenue]]
            [js-budget-analyzer.work-weeks :refer [work-weeks]]
            ))
(defn weekly-revenue
  [employees employee deals average-deal]
  (/ (annual-revenue employees employee deals average-deal)
     (work-weeks employee)))