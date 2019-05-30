(ns inmogr-budget.annual-revenue 
    (:require [inmogr-budget.rev-hour :refer [rev-hour]]))
(defn annual-revenue
  [employees employee deals average-deal]
  (* (rev-hour employees deals average-deal)
     (get employee :hours)))