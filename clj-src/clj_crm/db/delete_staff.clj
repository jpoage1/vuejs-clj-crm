(ns clj-crm.db.delete-staff
  (:require [clj-crm.db.wrappers :refer [delete]]))
(defn delete-staff [id]
  (delete :staff id))