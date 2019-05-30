(ns inmogr-budget.devs-weekly-revenue
  (:require [inmogr-budget.dev-weekly-revenue :refer [dev-weekly-revenue] :reload true]))
(defn devs-weekly-revenue
  [devs productRate]
  (reduce +
          (map devs
               (fn [dev]
                 (dev-weekly-revenue dev, productRate)))))