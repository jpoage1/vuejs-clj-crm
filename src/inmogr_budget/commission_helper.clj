(ns inmogr-budget.commission-helper
  (:require [inmogr-budget.utilities.math :refer [evaluate]]
	 [inmogr-budget.utilities.casting :refer [to-integer]]))
(defn commission-helper
  [employee revenue]

  (* (to-integer revenue)
     (evaluate (get employee :rate))))