(ns clj-crm.db.read-staff
  (:require [clj-crm.db.wrappers :refer [query] :reload true]))
(def read-all-staff
  #(query ["SELECT * FROM staff"]))
(defn read-staff [id]
  (query ["SELECT * FROM staff WHERE id = ?" id]))
(defn read-team [id]
  (query ["SELECT * FROM staff WHERE team = ?" id]))