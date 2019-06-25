(ns clj-crm.db.read-config
  (:require [clj-crm.db.wrappers :refer [query]]
            [clj-crm.send-json :refer [send-json]]))
(defn read-config [id]
  (query ["SELECT * FROM config WHERE id = ?" id]))
(defn read-all-config []
  (query ["SELECT * FROM config"]))
(defn http-read-config [request]
  (send-json (read-all-config) 200))