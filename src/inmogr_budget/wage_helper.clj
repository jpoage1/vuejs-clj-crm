(ns inmogr-budget.wage-helper
  (:require [inmogr-budget.data.labels  :refer [developer sdr manager]]
            [inmogr-budget.hourly-wage-helper :refer [hourly-wage-helper] :reload true]
            [inmogr-budget.commission-helper :refer [commission-helper] :reload true]))
(defn wage-helper
  [config role] 
  ((get {manager
         (fn [employee revenue]
           (hourly-wage-helper config employee revenue))
         developer (fn [employee revenue]
                     (hourly-wage-helper config employee revenue))
         sdr (fn [employee revenue]
               (commission-helper employee revenue))} role)))