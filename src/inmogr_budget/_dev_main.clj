(ns inmogr-budget.core
  (:gen-class)
  (:require
   [inmogr-budget.start-server :refer [start-server]]
   [inmogr-budget.app :refer [app]]
   [clojure.core :as clojure]
   [ring.middleware.reload :refer [wrap-reload]]))
(defn -dev-main
  [port-number]
  (start-server port-number (wrap-reload (app))))