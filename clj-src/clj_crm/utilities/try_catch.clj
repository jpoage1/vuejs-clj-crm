(ns clj-crm.utilities.try-catch)
(defn try-catch [statement]
  (try statement
       (catch  Exception e (str "caught exception: " (.getMessage e)))))