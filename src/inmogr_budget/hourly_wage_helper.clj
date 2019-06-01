(ns inmogr-budget.hourly-wage-helper
  (:require [inmogr-budget.utilities.math :refer [evaluate]]
	 [inmogr-budget.utilities.casting :refer [to-integer]]))
(defn hourly-wage-helper
  [config employee revenue]

  (*
   (/ revenue  (to-integer (get config :product-rate)))
   (evaluate (get employee :rate))))