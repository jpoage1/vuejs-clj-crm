(ns js-budget-analyzer.dev-annual-revenue
  (:require [js-budget-analyzer.dev-weekly-revenue :refer [dev-weekly-revenue]]
            [js-budget-analyzer.work-weeks :refer [work-weeks]]
            ))
(defn dev-annual-revenue
  [config dev]

  (*
   (dev-weekly-revenue config dev)
   (work-weeks dev)))