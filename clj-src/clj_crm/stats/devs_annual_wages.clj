(ns clj-crm.stats.devs-annual-wage
(:require [clj-crm.stats.dev-annual-wages :refer [dev-annual-wages]]
          ))
(defn devs-annual-wages
  [devs]
  (map
   (fn [dev]
     (reduce +
             (dev-annual-wages dev rate)))
   devs))