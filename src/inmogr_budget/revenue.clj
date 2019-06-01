(ns inmogr-budget.revenue
	(:require [inmogr-budget.utilities.casting :refer [to-integer]]))
(defn revenue
  [deals average-deal]
  (prn 'revenue (type deals))
  (* (to-integer average-deal) (to-integer deals)))