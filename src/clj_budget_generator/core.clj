(ns js-budget-analyzer.core
  (:gen-class)
  (:require
   [js-budget-analyzer.app :refer [app]]
   [js-budget-analyzer.start-server :refer [start-server]]
   [ring.middleware.reload :refer [wrap-reload]]
   ))

(defn -dev-main
  [port-number]
  (start-server port-number (wrap-reload #'app)))
(defn -main
  [port-number]
  (start-server port-number #'app))
