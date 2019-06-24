(ns js-budget-analyzer.cost-per-employee
  (:require [js-budget-analyzer.staff-by-role :refer [staff-by-role]]
            [js-budget-analyzer.total-cost :refer [total-cost]]
            ))
(defn cost-per-employee
[staff role]
    (let [employees (staff-by-role staff role)]
    (/ (total-cost employees role) (count employees)))) ; employee.length might be wrong