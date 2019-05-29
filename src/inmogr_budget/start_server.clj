(ns inmogr-budget.start-server
  (:require
   [clojure.core :as clojure]
   [ring.adapter.jetty :as jetty]
   [ring.middleware.gzip :refer [wrap-gzip]]
   [ring.middleware.json :refer [wrap-json-body wrap-json-params]])
  (:use [ring.adapter.jetty]
        [ring.middleware.cookies]
        [ring.middleware.params]))
(defn start-server [port-number app]
  (run-jetty (wrap-cookies (wrap-gzip app)) {:port (Integer/parseInt port-number)}))