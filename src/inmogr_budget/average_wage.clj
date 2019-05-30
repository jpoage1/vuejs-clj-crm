(ns inmogr-budget.average-wage
    (:require [inmogr-budget.data.labels  :refer [developer]]
              [inmogr-budget.staff-by-role :refer [staff-by-role]]
              [inmogr-budget.total-cost :refer [total-cost]]
              [inmogr-budget.total-hours :refer [total-hours]]
              [inmogr-budget.conversions-to-deal :refer [conversions-to-deal]]))
(defn average-wage
  [staff role]
  (let [employees (staff-by-role staff role)]
    (/ (totalCost employees) (totalHours employees))))