(ns inmogr-budget.dev-annual-revenue
  (:require [inmogr-budget.dev-weekly-revenue :refer [dev-weekly-revenue]]
            [inmogr-budget.work-weeks :refer [work-weeks]]))
(defn dev-annual-revenue
  [dev product-rate]
  (*
   (dev-weekly-revenue dev product-rate)
   (work-weeks dev)))