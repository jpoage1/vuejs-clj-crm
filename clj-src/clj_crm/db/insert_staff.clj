(ns clj-crm.db.insert-staff
            (:require [clj-crm.db.wrappers :refer [insert] :reload true]))
(defn parse-staff
  "This function is practically useless at the moment, until I get into data validation.
Its primary puprose at the moment is to assure the correct arguments are passed to the database"
  [{:keys [first-name last-name team role rate hours vacation]}]
  {:first-name first-name
   :last-name last-name
   :team team
   :role role
   :rate rate
   :hours hours
   :vacation vacation})
(defn insert-staff
  [staff]
  (insert :staff (if (map? staff) (map parse-staff staff) (parse-staff staff))))