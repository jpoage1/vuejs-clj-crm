(ns clj-crm.stats.stats-by-role
  (:require [clj-crm.stats.staff-by-role :refer [staff-by-role]]
            [clj-crm.stats.employee-stat :refer [employee-stat]]
            ))
(defn stats-by-role
  [staff role product-rate devs sdrs]
  (map
   (fn [employee]
     (get
      (employee-stat employee product-rate devs sdrs)
      (get employee :role)))
   (staff-by-role staff role)))