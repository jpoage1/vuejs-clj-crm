(ns inmogr-budget.calc-hours
	(:require [inmogr-budget.utilities.casting :refer [to-integer]]))
(defn calc-hours
  [config h & {:keys [overtime]
                   :or {overtime true}}]

   (let [hours (to-integer h)
   					full-time (to-integer (get config :full-time))

        overtime (if (> hours hours full-time)
                    full-time
                    0)

         overtime-hours (if (> hours full-time)
                          full-time
                          0)


         regular-hours (- hours overtime-hours)

         half-time (/ overtime-hours 2)

         total-hours (if overtime (+ half-time hours) regular-hours)]

        (int total-hours)))