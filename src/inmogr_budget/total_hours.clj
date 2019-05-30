(ns inmogr-budget.total-hours)
(defn total-hours [staff]
  (reduce +
          (map staff
               (fn [staff]
                 (Integer/parseInt(get staff :hours))))))