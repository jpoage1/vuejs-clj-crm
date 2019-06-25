(ns clj-crm.db.update-staff
  (:require [clj-crm.db.wrappers :refer [update]]))
(defn update-staff [{:keys [id first-name last-name team role rate hours vacation]}]
  (update :staff
          {:first-name first-name
           :last-name last-name
           :team team
           :role role
           :rate rate
           :hours hours
           :vacation vacation} ["id = ?" id]))