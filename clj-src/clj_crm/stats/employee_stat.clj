(ns clj-crm.stats.employee-stat
  (:require [clj-crm.utilities.math :refer [evaluate]]
            [clj-crm.stats.wage-helper :refer [wage-helper]]
            [clj-crm.stats.weekly-wage :refer [weekly-wage]]
            [clj-crm.stats.annual-revenue :refer [annual-revenue]]
            [clj-crm.stats.annual-wage :refer [annual-wage]]
            [clj-crm.stats.weekly-revenue :refer [weekly-revenue]]
            ))
(defn get-stat
  [employees employee deals average-deal]

  (fn
    ([f] 
     (f employees employee deals average-deal))
    ([f h]
     (f employees employee deals average-deal h))))
(defn employee-stat
  [config employees employee deals]

  (let [employee-role (get employee :role)
        helper (wage-helper config employee employee-role)
         {average-deal :average-deal} config
        stat (get-stat employees employee deals average-deal)]
        ;this can get cleaned up a bit, not enough recursion and lots of repeating
    (merge employee {:rate (evaluate (get employee :rate))
                     :weekly-revenue (stat weekly-revenue)
                     :weekly-wages (stat weekly-wage helper)
                     :annual-revenue (stat annual-revenue)
                     :annual-wages (stat annual-wage helper)
                     })))