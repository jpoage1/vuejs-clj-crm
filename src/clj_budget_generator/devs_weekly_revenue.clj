(ns js-budget-analyzer.devs-weekly-revenue
  (:require [js-budget-analyzer.dev-weekly-revenue :refer [dev-weekly-revenue] :reload true]
            ))
(defn devs-weekly-revenue
  [config devs]


  (reduce +
          (map
           (fn [dev]
             (dev-weekly-revenue config dev))
           devs)))