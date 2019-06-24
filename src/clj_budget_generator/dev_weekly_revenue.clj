(ns js-budget-analyzer.dev-weekly-revenue
  (:require [js-budget-analyzer.dev-weekly-earnings :refer [dev-weekly-earnings] :reload true]
            ))
(defn dev-weekly-revenue
  [config dev]

  (dev-weekly-earnings config dev))