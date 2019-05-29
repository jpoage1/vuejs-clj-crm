(ns inmogr-budget.-main
  (:gen-class)
  (:require
   [inmogr-budget.start-server :refer [start-server]]
   [inmogr-budget.app :refer [app]]
   [clojure.core :as clojure]))
(defn -main
  [port-number]
  (start-server port-number (app)))
