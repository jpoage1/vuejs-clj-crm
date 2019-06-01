(ns inmogr-budget.work-weeks
	(:require [inmogr-budget.utilities.casting :refer [to-integer]]))
(defn work-weeks
  [employee]
  (- 52
     (to-integer (get employee :vacation))))