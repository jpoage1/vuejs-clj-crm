(ns clj-crm.stats.all-config-stats
    (:require [clj-crm.stats.config-stats :refer [config-stats]]
              ))
(defn all-config-stats
  [config staff]
  (map
   (fn [config]
     (config-stats config staff))
   config))