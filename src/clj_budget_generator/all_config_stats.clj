(ns js-budget-analyzer.all-config-stats
    (:require [js-budget-analyzer.config-stats :refer [config-stats]]
              ))
(defn all-config-stats
  [config staff]
  (map
   (fn [config]
     (config-stats config staff))
   config))