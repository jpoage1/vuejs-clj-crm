(ns clj-crm.db.delete-config
  (:require [clj-crm.db.wrappers :refer [delete]]))
(defn delete-config [id]
  (delete :config id))