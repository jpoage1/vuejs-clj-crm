(ns clj-crm.error-message
  (:require [clj-crm.send-json :refer [send-json]]))
(def error-message (send-json "Error" 404))