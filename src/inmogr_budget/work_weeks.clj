(ns inmogr-budget.work-weeks)
(defn work-weeks
  [employee]
    (- 52 (get employee :vacation)))