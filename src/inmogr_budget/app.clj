(ns inmogr-budget.app
  (:require
   [inmogr-budget.error-message :refer [error-message]]
   [inmogr-budget.stats :refer [stats]]
   [compojure.core :refer [GET defroutes]]
   [compojure.route :refer [not-found]])
  (:use [compojure.core]))
(defroutes app (POST "/stats" [] stats)
  (not-found error-message))