(ns clj-crm.stats.dev-annual-revenue
  (:require [clj-crm.stats.dev-weekly-revenue :refer [dev-weekly-revenue]]
            [clj-crm.stats.work-weeks :refer [work-weeks]]
            ))
(defn dev-annual-revenue
  [config dev]

  (*
   (dev-weekly-revenue config dev)
   (work-weeks dev)))