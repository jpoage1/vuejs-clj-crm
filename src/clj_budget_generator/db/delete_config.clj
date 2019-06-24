(ns js-budget-analyzer.db.delete-config
  (:require [js-budget-analyzer.db.wrappers :refer [delete] :reload true]))
(defn delete-config [id]
  (delete :config id))