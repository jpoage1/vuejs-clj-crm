(ns clj-crm.stats.weekly-wages
  (:require [weekly-wages :refer [weekly-wage]]
            ))
(defn weekly-wages [employees deals average-deal]
  (reduce +
          (map
           (fn [employee]
             (weekly-wage employees employee deals average-deal))
           employees)))