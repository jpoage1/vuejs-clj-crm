(ns inmogr-budget.app
  (:require
   [clojure.core :as clojure]
   [inmogr-budget.error-message :refer [error-message]]
   [inmogr-budget.stats :refer [stats]]
   [inmogr-budget.start-server :refer [start-server]]
   [ring.middleware.reload :refer [wrap-reload]]
   [compojure.core :refer [GET defroutes]]
   [compojure.route :refer [not-found]])
  (:use [compojure.core]
        [ring.adapter.jetty]
        [ring.middleware.params]))
(defroutes app (POST "/stats" [] stats)
  (not-found error-message))