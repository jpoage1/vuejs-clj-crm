(ns inmogr-budget.devs-annual-wage
(:require [inmogr-budget.dev-annual-wages :refer [dev-annual-wages]]))
(defn devs-annual-wages
  [devs]
  (map devs
       (fn [dev]
         (reduce +
                 (dev-annual-wages dev rate)))))