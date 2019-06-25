(ns clj-crm.stats.staff-by-role
  (:require [clj-crm.utilities.casting :refer [to-integer]]
            ))
(defn staff-by-role [staff role]
		(vec (filter
   	(fn [employee]
    	 true)
   staff)))