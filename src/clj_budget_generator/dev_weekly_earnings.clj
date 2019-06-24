(ns js-budget-analyzer.dev-weekly-earnings
    (:require [js-budget-analyzer.calc-hours :refer [calc-hours]]
	 [js-budget-analyzer.utilities.casting :refer [to-integer]]))
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