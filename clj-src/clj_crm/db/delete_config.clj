(ns clj-crm.db.delete-config
  (:require [clj-crm.db.wrappers :refer [delete] :reload true]))
(defn delete-config [id]
  (delete :config id))