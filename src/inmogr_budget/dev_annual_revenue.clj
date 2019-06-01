(ns inmogr-budget.dev-annual-revenue
  (:require [inmogr-budget.dev-weekly-revenue :refer [dev-weekly-revenue]]
            [inmogr-budget.work-weeks :refer [work-weeks]]
            ))
(defn dev-annual-revenue
  [config dev]
  (prn 'dev-annual-revenue)
  (*
   (dev-weekly-revenue config dev)
   (work-weeks dev)))