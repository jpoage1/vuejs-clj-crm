(ns js-budget-analyzer.dev-weekly-wages
  (:require [js-budget-analyzer.dev-weekly-earnings :refer [dev-weekly-earnings]]
            ))
(defn dev-meekly-wages
  [dev]
  (dev-weekly-earnings dev (get dev :rate)))