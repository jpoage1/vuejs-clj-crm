(ns inmogr-budget.calc-hours
	(:require [inmogr-budget.utilities.casting :refer [to-integer]]))
(defn calc-hours
  [config h & {:keys [overtime]
                   :or {overtime true}}]
                   (prn 'calc-hours)
   (let [hours (to-integer h)
   					full-time (to-integer (get config :full-time))
        a (prn 'a  full-time)
        overtime (if (> hours hours full-time)
                    full-time
                    0)
        b (prn 'b overtime)
         overtime-hours (if (> hours full-time)
                          full-time
                          0)

        c (prn 'c overtime-hours)
         regular-hours (- hours overtime-hours)
        d (prn 'd regular-hours)
         half-time (/ overtime-hours 2)
         e (prn 'e half-time)
         total-hours (if overtime (+ half-time hours) regular-hours)]
         (prn (int total-hours))
        (int total-hours)))