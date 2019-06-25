(ns clj-crm.stats.total-hours
	(:require [clj-crm.utilities.casting :refer [to-integer]]))
(defn staff-hours
  [staff]
  (map
   (fn [employee]
       (to-integer (get employee :hours)))
   staff))
(defn total-hours [staff]
  (reduce +
          (vec (staff-hours  staff))))