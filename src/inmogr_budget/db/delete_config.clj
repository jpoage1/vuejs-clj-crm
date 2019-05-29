(ns inmogr-budget.db.delete-config
  (:require [inmogr-budget.db.wrappers :refer [delete] :reload true]))
(defn delete-config [id]
  (delete :config id))