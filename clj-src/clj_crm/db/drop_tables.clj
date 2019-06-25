(ns clj-crm.db.drop-tables
  (:require [clj-crm.db.wrappers :refer [db-do-commands]]
            [clojure.java.jdbc :refer [drop-table-ddl]]))
(def drop-config-table-ddl (drop-table-ddl :staff))
(def drop-roles-table-ddl (drop-table-ddl :staff))
(def drop-staff-table-ddl (drop-table-ddl :staff))
(def drop-config-table
  #(db-do-commands drop-config-table-ddl))
(def drop-roles-table
  #(db-do-commands drop-roles-table-ddl))
(def drop-staff-table
  #(db-do-commands drop-staff-table-ddl))