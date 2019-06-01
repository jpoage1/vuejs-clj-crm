(ns inmogr-budget.weekly-revenue
  (:require [inmogr-budget.annual-revenue :refer [annual-revenue]]
            [inmogr-budget.work-weeks :refer [work-weeks]]
            ))
(defn weekly-revenue
  [employees employee deals average-deal]
  (/ (annual-revenue employees employee deals average-deal)
     (work-weeks employee)))