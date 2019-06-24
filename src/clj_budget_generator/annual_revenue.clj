(ns js-budget-analyzer.annual-revenue 
    (:require [js-budget-analyzer.rev-hour :refer [rev-hour]]
	 [js-budget-analyzer.utilities.casting :refer [to-integer]]))
(defn annual-revenue
  [employees employee deals average-deal]

  (* (rev-hour employees deals average-deal)
     (to-integer (get employee :hours))))