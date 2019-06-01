(ns inmogr-budget.cost-per-employee
  (:require [inmogr-budget.staff-by-role :refer [staff-by-role]]
            [inmogr-budget.total-cost :refer [total-cost]]
            ))
(defn cost-per-employee
[staff role]
    (let [employees (staff-by-role staff role)]
    (/ (total-cost employees role) (count employees)))) ; employee.length might be wrong