(ns inmogr-budget.all-config-stats
    (:require [inmogr-budget.config-stats :refer [config-stats]]
              ))
(defn all-config-stats
  [config staff]
  (map
   (fn [config]
     (config-stats config staff))
   config))