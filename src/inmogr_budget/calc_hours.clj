(ns inmogr-budget.calc-hours)
(defn calc-hours
  ([config hours] (calc-hours config hours false))
  ([config hours overtime]
   (let [overtime (if (> hours hours (get config :full-time))
                    (get config :full-time)
                    0)
         overtime-hours (if (> hours (get config :full-time))
                          (get config :full-time)
                          0)
         regular-hours (- hours overtime-hours)
         half-time (/ overtime-hours 2)
         total-hours (if overtime (+ half-time hours) regular-hours)]
     (int total-hours))))