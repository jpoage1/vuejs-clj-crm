(ns inmogr-budget.core
  (:gen-class)
  (:require
   [clojure.core :as clojure]
   [inmogr-budget.app :refer [app]]
   [inmogr-budget.start-server :refer [start-server]]
   [ring.middleware.reload :refer [wrap-reload]]
   [compojure.core :refer [GET defroutes]]
   [compojure.route :refer [not-found]])
  (:use [compojure.core]
        [ring.adapter.jetty]
        [ring.middleware.params]))

(defn -main
  [port-number]
  (start-server port-number (wrap-reload app)))
(defn main
  [port-number]
  (start-server port-number app))
