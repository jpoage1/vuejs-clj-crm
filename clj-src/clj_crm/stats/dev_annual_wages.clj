(ns clj-crm.stats.dev-annual-wage.clj
  (:require [clj-crm.stats.dev-weekly-wages :refer [dev-weekly-wages]]
            [clj-crm.stats.work-weeks :refer [work-weeks]]
            ))
(defn dev-annual-wages
  [employee]
  (*
   (dev-weekly-wages employee)
   (work-weeks employee)))