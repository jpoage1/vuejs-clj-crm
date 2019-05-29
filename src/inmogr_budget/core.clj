(ns inmogr-budget.core
  (:gen-class)
  (:require
   [clojure.core :as clojure]
   [inmogr-budget.error-message :refer [error-message]]
   [inmogr-budget.stats :refer [stats]]
   [inmogr-budget.start-server :refer [start-server]]
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
(defroutes app (POST "/stats" [] stats)
  (not-found error-message))

(defn -main
  [port-number]
  (start-server port-number (wrap-reload app)))
(defn main
  [port-number]
  (start-server port-number app))
