(ns js-budget-analyzer.app
  (:require
   [js-budget-analyzer.error-message :refer [error-message]]
   [js-budget-analyzer.stats :as stats]
   [compojure.core :refer [GET POST defroutes]]
   [compojure.route :refer [not-found]]
   )
  (:use [compojure.core]))
(defroutes app (POST "/stats" [] stats/read-stats)
 ; (GET "/stats" [] stats/query-stats)
  ;(GET "/stats/lookup" [] stats/lookup-stats)
  (not-found error-message))