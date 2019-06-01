(ns inmogr-budget.devs-annual-revenue
  (:require [inmogr-budget.dev-annual-revenue :refer [dev-annual-revenue]]
            ))
(defn devs-annual-revenue
  [config devs]

  (reduce +
          (map
           (fn [dev]
             (dev-annual-revenue config dev))
           devs)))