(ns js-budget-analyzer.manager-annual-wages
  (:require [js-budget-analyzer.manager-weekly-wages :refer [manager-weekly-wages]]
            [js-budget-analyzer.workWeeks :refer [workWeeks]]
            ))
(defn manager-annual-wages
  [employee, devs, sdrs, product-rate]
  (*
   (manager-weekly-wages devs, sdrs, product-rate)
   (work-weeks employee)))