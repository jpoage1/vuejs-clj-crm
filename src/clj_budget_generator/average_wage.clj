(ns js-budget-analyzer.average-wage
    (:require [js-budget-analyzer.data.labels  :refer [developer]]
              [js-budget-analyzer.staff-by-role :refer [staff-by-role]]
              [js-budget-analyzer.total-cost :refer [total-cost]]
              [js-budget-analyzer.total-hours :refer [total-hours]]
              [js-budget-analyzer.conversions-to-deals :refer [conversions-to-deals]]
              ))
(defn average-wage
  [staff role]
  (let [employees (staff-by-role staff role)]
    (/ (total-cost employees) (total-hours employees))))