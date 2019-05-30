(ns inmogr-budget.total-hours)
(defn total-hours [staff]
  (reduce +
          (map
           (fn [staff]
             (Integer/parseInt (get staff :hours)))
           staff)))