(ns inmogr-budget.core
  (:gen-class)
  (:require
   [clojure.core :as clojure]
   [inmogr-budget.send-json :refer [send-json]]
   [ring.middleware.reload :refer [wrap-reload]]
   [ring.adapter.jetty :as jetty]
   [ring.middleware.gzip :refer [wrap-gzip]]
   [ring.middleware.json :refer [wrap-json-body wrap-json-params]]
   [ring.util.request :refer [body-string]]
   [compojure.core :refer [GET defroutes]]
   [compojure.route :refer [not-found]])
  (:use [compojure.core]
        [ring.adapter.jetty]
        [ring.middleware.cookies]
        [ring.middleware.params]))

(def error-message (send-json ["Error"] 404))
(defn stats [request]
  (send-json (body-string request)))


(defroutes app (POST "/stats" [] stats)
  (not-found error-message))

(defn start-server [port-number app]
  (run-jetty (wrap-cookies (wrap-gzip #'app)) {:port (Integer/parseInt port-number)}))

(defn -main
  [port-number]
  (start-server port-number (wrap-reload app)))
(defn main
  [port-number]
  (start-server port-number app))
