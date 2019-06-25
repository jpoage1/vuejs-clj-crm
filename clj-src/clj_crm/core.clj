(ns clj-crm.core
  (:gen-class)
  (:require
   [clj-crm.app :refer [app]]
   [clj-crm.start-server :refer [start-server]]
   [ring.middleware.reload :refer [wrap-reload]]
   ))

(def default-port 8000)

(defn -dev-main
  ([] (-dev-main default-port))
  ([port-number]
   (println "Starting development server server on port " port-number)
   (start-server port-number (wrap-reload #'app))))
(defn -main
  ([] (-main default-port))
  ([port-number]
   (println "Starting production server server on port " port-number)
   (def server (start-server port-number #'app))))

(defn reload-server []
  (require 'clj-crm.app :reload-all)
  (server)
  (def server (-dev-main 8000)))