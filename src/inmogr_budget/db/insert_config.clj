(ns inmogr-budget.db.insert-config
  (:require [inmogr-budget.db.wrappers :refer [insert] :reload true]))
(defn parse-config
  "This function is practically useless at the moment, until I get into data validation.
Its primary puprose at the moment is to assure the correct arguments are passed to the database"
  [{:keys [id average_deal product_rate prospect_to_lead lead_to_sale qualified_to_sale]}]
  {:average_deal :int
   :product_rate :int
   :prospect_to_lead :int
   :lead_to_sale :int
   :qualified_to_sale :int})
(defn insert-config
  [config]
  (insert :config config)
  ;(insert :config (if (map? config) (map parse-config config) (parse-config config))))