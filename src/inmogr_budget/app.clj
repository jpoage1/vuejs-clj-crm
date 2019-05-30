(ns inmogr-budget.app
  (:require
   [inmogr-budget.error-message :refer [error-message] :reload-all true]
   [inmogr-budget.stats :as stats :reload-all true]
   [compojure.core :refer [GET POST defroutes]]
   [compojure.route :refer [not-found]])
  (:use [compojure.core]))
(defroutes app (POST "/stats" [] stats/read-stats)
 ; (GET "/stats" [] stats/query-stats)
  ;(GET "/stats/lookup" [] stats/lookup-stats)
  ;(not-found error-message)
)