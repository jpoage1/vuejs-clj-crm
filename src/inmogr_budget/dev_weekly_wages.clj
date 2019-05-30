(ns inmogr-budget.dev-weekly-wages
  (:require [inmogr-budget.dev-weekly-earnings :refer [devWeeklyEarnings]]))
(defn dev-meekly-wages
  [dev]
  (devWeeklyEarnings dev (get dev :rate)))