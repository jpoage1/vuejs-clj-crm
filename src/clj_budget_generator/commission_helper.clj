(ns js-budget-analyzer.commission-helper
  (:require [js-budget-analyzer.utilities.math :refer [evaluate]]
	 [js-budget-analyzer.utilities.casting :refer [to-integer]]))
(defn commission-helper
  [employee revenue]

  (* (to-integer revenue)
     (evaluate (get employee :rate))))