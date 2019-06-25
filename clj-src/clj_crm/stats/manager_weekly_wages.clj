(ns clj-crm.stats.manager-weekly-wages
  (:require [clj-crm.stats.devs-weekly-revenue :refer [devs-weekly-revenue]]
            [clj-crm.stats.sdrs-weekly-wages :refer [sdrs-weekly-wages]]
            [clj-crm.stats.devs-weekly-wages :refer [devs-weekly-wages]]
            ))
(defn manager-weekly-wages
  [devs sdrs product-rate]
  (let [difference (devs-weekly-revenue devs product-rate)
        (sdrs-weekly-wages devs product-rate sdrs)
        (devs-weekly-wages devs)]
    (reduce - difference)))