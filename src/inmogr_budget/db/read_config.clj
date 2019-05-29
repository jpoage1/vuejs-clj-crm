(ns inmogr-budget.db.read-config
  (:require [inmogr-budget.db.wrappers :refer [query] :reload true]))
(defn read-config [id]
  (query ["SELECT * FROM config WHERE id = ?" id]))
(def read-all-config
  #(query ["SELECT * FROM config"]))