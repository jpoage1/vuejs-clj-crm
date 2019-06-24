(ns js-budget-analyzer.devs-annual-revenue
  (:require [js-budget-analyzer.dev-annual-revenue :refer [dev-annual-revenue]]
            ))
(defn devs-annual-revenue
  [config devs]

  (reduce +
          (map
           (fn [dev]
             (dev-annual-revenue config dev))
           devs)))