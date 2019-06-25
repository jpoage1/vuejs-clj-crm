(ns clj-crm.stats.wage-helper
  (:require [clj-crm.data.labels  :refer [developer sdr manager]]
  									 [clj-crm.utilities.casting  :refer [to-integer]]
            [clj-crm.stats.hourly-wage-helper :refer [hourly-wage-helper]]
            [clj-crm.stats.commission-helper :refer [commission-helper]]
            ))
(defn wage-helper
  [config employee role] 
  (let [wage-by-role {manager (fn [employee revenue]
                       								 (hourly-wage-helper config employee revenue))
                      developer (fn [employee revenue]
                                  (hourly-wage-helper config employee revenue))
                      sdr (fn [employee revenue]
                            (commission-helper employee revenue))}
                      r (to-integer role)]
     (get wage-by-role r)))