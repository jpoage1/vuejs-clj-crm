(ns inmogr-budget.hourly-wage-helper
  (:require [inmogr-budget.math :refer [evaluate]]))
(defn hourly-wage-helper
  [config employee revenue]
  (* 
   (/ revenue (Integer/parseInt (get config :product-rate)))
   (evaluate ((get employee :rate)))))