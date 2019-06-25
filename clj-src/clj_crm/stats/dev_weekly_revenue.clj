(ns clj-crm.stats.dev-weekly-revenue
  (:require [clj-crm.stats.dev-weekly-earnings :refer [dev-weekly-earnings] :reload true]
            ))
(defn dev-weekly-revenue
  [config dev]

  (dev-weekly-earnings config dev))