(ns clj-crm.stats.devs-weekly-revenue
  (:require [clj-crm.stats.dev-weekly-revenue :refer [dev-weekly-revenue]]
            ))
(defn devs-weekly-revenue
  [config devs]


  (reduce +
          (map
           (fn [dev]
             (dev-weekly-revenue config dev))
           devs)))