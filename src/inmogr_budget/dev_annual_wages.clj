(ns inmogr-budget.dev-annual-wage.clj
  (:require [inmogr-budget.dev-weekly-wages :refer [dev-weekly-wages]]
            [inmogr-budget.work-weeks :refer [work-weeks]]
            ))
(defn dev-annual-wages
  [employee]
  (*
   (dev-weekly-wages employee)
   (work-weeks employee)))