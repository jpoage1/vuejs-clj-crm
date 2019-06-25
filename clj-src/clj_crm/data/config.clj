(ns clj-crm.data.config)
(def config [{:full-time 40
              :average-deal 3500
              :product-rate 150, ;Dollars Per Hour
              :prospect-to-lead ".10", ; Rate of conversion in decimal format
              :lead-to-qualified ".10"
              :qualified-to-sale ".10"}])