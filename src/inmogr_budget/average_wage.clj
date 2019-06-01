(ns inmogr-budget.average-wage
    (:require [inmogr-budget.data.labels  :refer [developer]]
              [inmogr-budget.staff-by-role :refer [staff-by-role]]
              [inmogr-budget.total-cost :refer [total-cost]]
              [inmogr-budget.total-hours :refer [total-hours]]
              [inmogr-budget.conversions-to-deals :refer [conversions-to-deals]]
              ))
(defn average-wage
  [staff role]
  (let [employees (staff-by-role staff role)]
    (/ (total-cost employees) (total-hours employees))))