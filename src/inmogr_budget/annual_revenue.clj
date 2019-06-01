(ns inmogr-budget.annual-revenue 
    (:require [inmogr-budget.rev-hour :refer [rev-hour]]
	 [inmogr-budget.utilities.casting :refer [to-integer]]))
(defn annual-revenue
  [employees employee deals average-deal]

  (* (rev-hour employees deals average-deal)
     (to-integer (get employee :hours))))