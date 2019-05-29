(ns inmogr-budget.db.read-staff
  (:require [inmogr-budget.db.wrappers :refer [query] :reload true]))
(defn read-staff [id]
  (query ["SELECT * FROM staff WHERE id = ?" id]))
(def read-all-staff
  #(query ["SELECT * FROM staff"]))