(ns inmogr-budget.dev-weekly-earnings
    (:require [inmogr-budget.calc-hours :refer [calc-hours]]))
(defn dev-weekly-earnings 
([dev rate hours config] (dev-weekly-earnings dev rate hours config false))
([dev rate hours config overtime]
(let [n-hours (if hours
                hours
                (get dev :hours))
      total-hours (calc-hours config n-hours overtime)]
  (* total-hours rate))))