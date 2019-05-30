(ns inmogr-budget.staff-by-role)
(defn staff-by-role [staff role]
  (filter
   (fn [employee]
     (=
      (get employee :role)
      role))
   staff))