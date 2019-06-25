(ns clj-crm.db.update-staff
  (:refer-clojure :exclude [update])
  (:require [clj-crm.db.wrappers :refer [update]]))
(defn update-staff [{:keys [id average_deal product_rate prospect_to_lead lead_to_sale qualified_to_sale]}]
  (update :staff
          {:average_deal :int
           :product_rate :int
           :prospect_to_lead :int
           :lead_to_sale :int
           :qualified_to_sale :int} ["id = ?" id]))