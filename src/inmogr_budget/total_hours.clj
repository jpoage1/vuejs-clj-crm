(ns inmogr-budget.total-hours
	(:require [inmogr-budget.utilities.casting :refer [to-integer]]))
(defn staff-hours
  [staff]
  (map
   (fn [employee]
       (to-integer (get employee :hours)))
   staff))
(defn total-hours [staff]
(prn 'total-hours (reduce +
          (vec (staff-hours  staff))))
  (reduce +
          (vec (staff-hours  staff))))