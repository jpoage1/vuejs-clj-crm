(ns js-budget-analyzer.wage-helper
  (:require [js-budget-analyzer.data.labels  :refer [developer sdr manager]]
  									 [js-budget-analyzer.utilities.casting  :refer [to-integer]]
            [js-budget-analyzer.hourly-wage-helper :refer [hourly-wage-helper] :reload true]
            [js-budget-analyzer.commission-helper :refer [commission-helper] :reload true]
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