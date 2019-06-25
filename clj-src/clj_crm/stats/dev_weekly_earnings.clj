(ns clj-crm.stats.dev-weekly-earnings
    (:require [clj-crm.stats.calc-hours :refer [calc-hours]]
	 [clj-crm.utilities.casting :refer [to-integer]]))
(defn dev-weekly-earnings
  [config dev & {:keys [hours overtime]
                 :or {hours false
                      overtime true}}]
  (let [product-rate (to-integer (get config :product-rate))
        n-hours (if hours
                  hours
                  (get dev :hours))
        total-hours (calc-hours config n-hours :overtime overtime)]
    (* total-hours product-rate)))