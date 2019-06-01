(ns inmogr-budget.dev-weekly-wages
  (:require [inmogr-budget.dev-weekly-earnings :refer [dev-weekly-earnings]]
            ))
(defn dev-meekly-wages
  [dev]
  (dev-weekly-earnings dev (get dev :rate)))