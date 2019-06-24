(ns js-budget-analyzer.staff-by-role
  (:require [js-budget-analyzer.utilities.casting :refer [to-integer]]
            ))
(defn staff-by-role [staff role]
		(vec (filter
   	(fn [employee]
    	 true)
   staff)))