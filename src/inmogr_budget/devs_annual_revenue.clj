(ns inmogr-budget.devs-annual-revenue
  (:require [inmogr-budget.dev-annual-revenue :refer [dev-annual-revenue]]))
(defn devs-annual-revenue
  [devs product-rate]
  (reduce +
          (map devs
               (fn [dev]
                 (dev-annual-revenue dev product-rate)))))