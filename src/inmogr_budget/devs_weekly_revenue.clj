(ns inmogr-budget.devs-weekly-revenue
  (:require [inmogr-budget.dev-weekly-revenue :refer [dev-weekly-revenue] :reload true]
            ))
(defn devs-weekly-revenue
  [config devs]


  (reduce +
          (map
           (fn [dev]
             (dev-weekly-revenue config dev))
           devs)))