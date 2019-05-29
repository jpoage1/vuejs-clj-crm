(ns inmogr-budget.db.delete-staff
  (:require [inmogr-budget.db.wrappers :refer [delete] :reload true]))
(defn delete-staff [id]
  (delete :staff id))