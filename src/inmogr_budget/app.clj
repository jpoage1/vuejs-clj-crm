(ns inmogr-budget.app
  (:require
   [inmogr-budget.error-message :refer [error-message]]
   [inmogr-budget.stats :refer [read-stats] :reload true]
   [compojure.core :refer [GET defroutes]]
   [compojure.route :refer [not-found]])
  (:use [compojure.core]))
(defroutes app (POST "/stats" [] read-stats)
  (not-found error-message))