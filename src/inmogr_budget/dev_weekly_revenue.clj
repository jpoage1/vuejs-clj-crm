(ns inmogr-budget.dev-weekly-revenue
  (:require [inmogr-budget.dev-weekly-earnings :refer [dev-weekly-earnings] :reload true]
            ))
(defn dev-weekly-revenue
  [config dev]

  (dev-weekly-earnings config dev))