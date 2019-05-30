(ns inmogr-budget.core
  (:gen-class)
  (:require
   [inmogr-budget.app :refer [app] :reload-all true]
   [inmogr-budget.start-server :refer [start-server] :reload-all true]
   [ring.middleware.reload :refer [wrap-reload]]))

(defn -dev-main
  [port-number]
  (start-server port-number (wrap-reload app)))
(defn -main
  [port-number]
  (start-server port-number app))
