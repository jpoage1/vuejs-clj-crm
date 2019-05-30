(ns inmogr-budget.total-cost
  (:require [inmogr-budget.utilities.math :refer [evaluate] :reload true]
            [inmogr-budget.work-weeks :refer [work-weeks] :reload true]))
(defn total-cost [staff]
  (reduce +
          (map staff
               (fn [staff]
                 (*
                  (evaluate (get staff :rate))
                  (get staff :hours)
                  (work-weeks staff))))))