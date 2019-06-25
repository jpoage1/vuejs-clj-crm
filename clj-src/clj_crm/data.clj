(ns clj-crm.data
  (:require [clj-crm.send-json :refer [send-json]]))

(defn crud-get [request]
  (send-json ["Test"] 200))
(defn crud-post! [] nil)
(defn crud-put! [] nil)
(defn crud-delete! [] nil)