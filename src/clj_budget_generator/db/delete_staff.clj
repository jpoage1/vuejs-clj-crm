(ns js-budget-analyzer.db.delete-staff
  (:require [js-budget-analyzer.db.wrappers :refer [delete] :reload true]))
(defn delete-staff [id]
  (delete :staff id))