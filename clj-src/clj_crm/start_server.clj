(ns clj-crm.start-server
  (:require
   [ring.adapter.jetty :as jetty]
   [ring.middleware.gzip :refer [wrap-gzip]]
   [ring.middleware.params :refer [wrap-params]]
   [ring.middleware.json :refer [wrap-json-body wrap-json-params]]
   )
  (:use [ring.adapter.jetty]
        [org.httpkit.server :only [run-server]]
        [ring.middleware.cookies]
        [ring.middleware.params]))
(defn start-server [port-number app]
  (let [port (if
              (integer? port-number)
               port-number (Integer/parseInt port-number))]
    (run-server (-> app wrap-gzip wrap-cookies wrap-params) {:port port})))