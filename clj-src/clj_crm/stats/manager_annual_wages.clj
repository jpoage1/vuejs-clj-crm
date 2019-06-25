(ns clj-crm.stats.manager-annual-wages
  (:require [clj-crm.stats.manager-weekly-wages :refer [manager-weekly-wages]]
            [clj-crm.stats.workWeeks :refer [workWeeks]]
            ))
(defn manager-annual-wages
  [employee, devs, sdrs, product-rate]
  (*
   (manager-weekly-wages devs, sdrs, product-rate)
   (work-weeks employee)))