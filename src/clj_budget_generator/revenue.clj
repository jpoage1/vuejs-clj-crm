(ns js-budget-analyzer.revenue
	(:require [js-budget-analyzer.utilities.casting :refer [to-integer]]))
(defn revenue
  [deals average-deal]

  (* (to-integer average-deal) (to-integer deals)))