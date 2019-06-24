(ns js-budget-analyzer.db.wrappers
  (:refer-clojure :exclude [update])
  (:require [js-budget-analyzer.db.db-spec :refer [db-spec]]
            [js-budget-analyzer.utilities.try-catch :refer [try-catch]]
            [clojure.java.jdbc :as jdbc]))
(defn db-do-commands
  [command]
  (try-catch (jdbc/db-do-commands db-spec
                                  command)))
(defn delete [table id]
  (try-catch
   (jdbc/delete! db-spec table ["id = ?" id])))
(defn insert
  [table data]
  (try-catch
   (jdbc/insert! db-spec table data)))
(defn query [statement]
  (try-catch (jdbc/query db-spec statement)))
(defn update
  [table data id criteria]
  (try-catch
   (jdbc/update! db-spec table data criteria)))