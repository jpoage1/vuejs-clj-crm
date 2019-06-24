(ns js-budget-analyzer.dev-annual-wage.clj
  (:require [js-budget-analyzer.dev-weekly-wages :refer [dev-weekly-wages]]
            [js-budget-analyzer.work-weeks :refer [work-weeks]]
            ))
(defn dev-annual-wages
  [employee]
  (*
   (dev-weekly-wages employee)
   (work-weeks employee)))