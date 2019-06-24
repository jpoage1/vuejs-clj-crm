(ns js-budget-analyzer.total-cost
  (:require [js-budget-analyzer.utilities.math :refer [evaluate] :reload true]
            [js-budget-analyzer.work-weeks :refer [work-weeks] :reload true]
            ))
(defn total-cost [staff]
  (reduce +
          (map
           (fn [staff]
             (*
              (evaluate (get staff :rate))
              (get staff :hours)
              (work-weeks staff)))
           staff)))