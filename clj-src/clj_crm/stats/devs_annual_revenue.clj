(ns clj-crm.stats.devs-annual-revenue
  (:require [clj-crm.stats.dev-annual-revenue :refer [dev-annual-revenue]]
            ))
(defn devs-annual-revenue
  [config devs]

  (reduce +
          (map
           (fn [dev]
             (dev-annual-revenue config dev))
           devs)))