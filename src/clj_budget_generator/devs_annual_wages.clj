(ns js-budget-analyzer.devs-annual-wage
(:require [js-budget-analyzer.dev-annual-wages :refer [dev-annual-wages]]
          ))
(defn devs-annual-wages
  [devs]
  (map
   (fn [dev]
     (reduce +
             (dev-annual-wages dev rate)))
   devs))