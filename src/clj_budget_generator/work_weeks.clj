(ns js-budget-analyzer.work-weeks
	(:require [js-budget-analyzer.utilities.casting :refer [to-integer]]))
(defn work-weeks
  [employee]
  (- 52
     (to-integer (get employee :vacation))))