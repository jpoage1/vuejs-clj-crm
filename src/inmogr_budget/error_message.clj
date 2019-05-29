(ns inmogr-budget.error-message
  (:require
   [clojure.core :as clojure]
   [inmogr-budget.send-json :refer [send-json]]))
(def error-message (send-json "Error" 404))