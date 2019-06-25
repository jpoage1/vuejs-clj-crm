(ns clj-crm.db.create-tables
  (:require [clj-crm.db.wrappers :refer [db-do-commands]]
            [clojure.java.jdbc :refer [create-table-ddl]]))
(def create-config-table-ddl
  (create-table-ddl :config
                    [[:id :serial "PRIMARY KEY"]
                     [:name "varchar(32)"]
                     [:average_deal :int]
                     [:product_rate :int]
                     [:prospect_to_lead :int]
                     [:lead_to_sale :int]
                     [:qualified_to_sale :int]
                     [:created_at :timestamp]]))
(defn create-config-table! []
  (db-do-commands create-config-table-ddl))

(def create-staff-table-ddl
  (create-table-ddl :staff
                         [[:id :serial "PRIMARY KEY"]
                          [:first_name "varchar(32)"]
                          [:last_name "varchar(32)"]
                          [:team :int "REFERENCES staff(id)"]
                          [:role :int]
                          [:rate :int]
                          [:hours :int]
                          [:vacation :int]
                          [:created_at :timestamp]]))
(defn create-staff-table! []
  (db-do-commands create-staff-table-ddl))

(def create-roles-table-ddl
  (create-table-ddl :roles
                         [[:id :serial "PRIMARY KEY"]
                          [:name "varchar(32)"]
                          [:created_at :timestamp]]))
(defn create-roles-table! []
  (db-do-commands create-roles-table-ddl))