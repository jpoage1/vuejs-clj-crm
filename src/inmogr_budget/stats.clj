(ns inmogr-budget.stats
  (:require
   [clojure.core :as clojure]
   [inmogr-budget.send-json :refer [send-json]]
   [ring.util.request :refer [body-string]]))
(defn stats [request]
  (send-json (body-string request)))