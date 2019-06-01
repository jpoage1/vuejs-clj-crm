(ns inmogr-budget.manager-annual-wages
  (:require [inmogr-budget.manager-weekly-wages :refer [manager-weekly-wages]]
            [inmogr-budget.workWeeks :refer [workWeeks]]
            ))
(defn manager-annual-wages
  [employee, devs, sdrs, product-rate]
  (*
   (manager-weekly-wages devs, sdrs, product-rate)
   (work-weeks employee)))