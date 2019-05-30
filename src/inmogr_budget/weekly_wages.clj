(ns inmogr-budget.weekly-wages
  (:require [weekly-wages :refer [weekly-wage]]))
(defn weekly-wages [employees deals average-deal]
  (reduce +
          (map employees
               (fn [employee]
                 (weekly-wage employees employee deals average-deal)))))