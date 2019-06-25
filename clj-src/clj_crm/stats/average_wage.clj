(ns clj-crm.stats.average-wage
    (:require [clj-crm.data.labels  :refer [developer]]
              [clj-crm.stats.staff-by-role :refer [staff-by-role]]
              [clj-crm.stats.total-cost :refer [total-cost]]
              [clj-crm.stats.total-hours :refer [total-hours]]
              [clj-crm.stats.conversions-to-deals :refer [conversions-to-deals]]
              ))
(defn average-wage
  [staff role]
  (let [employees (staff-by-role staff role)]
    (/ (total-cost employees) (total-hours employees))))