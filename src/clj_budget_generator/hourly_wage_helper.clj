(ns js-budget-analyzer.hourly-wage-helper
  (:require [js-budget-analyzer.utilities.math :refer [evaluate]]
	 [js-budget-analyzer.utilities.casting :refer [to-integer]]))
(defn hourly-wage-helper
  [config employee revenue]

  (*
   (/ revenue  (to-integer (get config :product-rate)))
   (evaluate (get employee :rate))))