(ns clj-crm.db.wrappers
  (:refer-clojure :exclude [update])
  (:require [clj-crm.db.db-spec :refer [db-spec]]
            [clj-crm.utilities.try-catch :refer [try-catch]]
            [clojure.java.jdbc :as jdbc]))
(defn db-do-commands
  [command]
  (try-catch (jdbc/db-do-commands db-spec
                                  command)))
(defn delete! [table id]
  (try-catch
   (jdbc/delete! db-spec table ["id = ?" id])))
(defn insert!
  [table data]
  (try-catch
   (jdbc/insert! db-spec table data)))
(defn query [statement & args]
  (try-catch (apply jdbc/query db-spec statement args)))
(defn update!
  [table data id criteria]
  (try-catch
   (jdbc/update! db-spec table data criteria)))
