(ns clj-crm.app
  (:require
   [clj-crm.error-message :refer [error-message]]
   [clj-crm.stats :as stats]
   [clj-crm.db.read-config :refer [http-read-config]]
   [clj-crm.data :refer [crud-get crud-post! crud-put! crud-delete!]]
   [compojure.core :refer [GET POST defroutes]]
   [compojure.route :refer [not-found]]
   )
  (:use [compojure.core]))
(defroutes app (POST "/stats" [] stats/read-stats)
 ; (GET "/stats" [] stats/query-stats)
  ;(GET "/stats/lookup" [] stats/lookup-stats)
  (GET "/data/config" [] http-read-config)

;  (GET "/data/employees" [] (crud-get :employees))
;  (GET "/data/employee/:id" [] (crud-get :employee))

;  (GET "/data/customer-profiles" [] (crud-get :customer-profiles))
;  (GET "/data/customer-profile/:id" [] (crud-get :customer-profile))

;  (GET "/data/contacts" [] (crud-get :contacts))
;  (GET "/data/contact/:id" [] (crud-get :contact))

;  (GET "/data/companies" [] (crud-get :companies))
;  (GET "/data/company/:id" [] (crud-get :company))
  
;  (GET "/data/sequences" [] (crud-get :sequences))
;  (GET "/data/sequence/:id" [] (crud-get :sequence))

;  (GET "/data/deals" [] (crud-get :deals))
;  (GET "/data/deal/:id" [] (crud-get :deal))
  (not-found error-message))
