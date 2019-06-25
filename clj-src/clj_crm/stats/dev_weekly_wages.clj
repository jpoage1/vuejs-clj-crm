(ns clj-crm.stats.dev-weekly-wages
  (:require [clj-crm.stats.dev-weekly-earnings :refer [dev-weekly-earnings]]
            ))
(defn dev-meekly-wages
  [dev]
  (dev-weekly-earnings dev (get dev :rate)))