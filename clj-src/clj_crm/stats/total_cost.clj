(ns clj-crm.stats.total-cost
  (:require [clj-crm.utilities.math :refer [evaluate] :reload true]
            [clj-crm.stats.work-weeks :refer [work-weeks] :reload true]
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