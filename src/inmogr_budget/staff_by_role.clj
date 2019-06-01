(ns inmogr-budget.staff-by-role
  (:require [inmogr-budget.utilities.casting :refer [to-integer]]
            ))
(defn staff-by-role [staff role]
		(vec (filter
   	(fn [employee]
    	 true)
   staff)))