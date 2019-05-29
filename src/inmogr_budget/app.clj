(ns inmogr-budget.app
  (:require
   [clojure.core :as clojure]
   [inmogr-budget.error-message :refer error-message]
   [inmogr-budget.stats :refer [stats]]
   [compojure.route :as route]
   [compojure.core :refer [GET defroutes]])
  (:use [compojure.core]))
(defroutes app (POST "/stats" [] stats)
  (route/not-found error/error-message))