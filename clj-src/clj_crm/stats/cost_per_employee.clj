(ns clj-crm.stats.cost-per-employee
  (:require [clj-crm.stats.staff-by-role :refer [staff-by-role]]
            [clj-crm.stats.total-cost :refer [total-cost]]
            ))
(defn cost-per-employee
[staff role]
    (let [employees (staff-by-role staff role)]
    (/ (total-cost employees role) (count employees)))) ; employee.length might be wrong