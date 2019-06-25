(ns clj-crm.send-json
  (:require [clojure.data.json :as json]))
(defn send-json
  ([data] (send-json data 200))
  ([data status]
   {:status status
    :headers {"Content-Type" "application/json"}
    :cookies {"session_id" {:value "session-id-hash" :secure true :domain "127.0.0.1" :same-site :strict}}
    :body (json/write-str data)}))