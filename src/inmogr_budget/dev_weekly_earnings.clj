(ns inmogr-budget.dev-weekly-earnings
    (:require [inmogr-budget.calc-hours :refer [calc-hours]]))
(defn dev-weekly-earnings 
[dev rate & {:keys [hours config overtime]
:or {hours false
     config {}
     overtime true}}]
(let [n-hours (if hours
                hours
                (get dev :hours))
      total-hours (calc-hours config n-hours overtime)]
  (* total-hours rate)))