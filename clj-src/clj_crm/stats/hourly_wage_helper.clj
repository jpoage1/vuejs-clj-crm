(ns clj-crm.stats.hourly-wage-helper
  (:require [clj-crm.utilities.math :refer [evaluate]]
	 [clj-crm.utilities.casting :refer [to-integer]]))
(defn hourly-wage-helper
  [config employee revenue]

  (*
   (/ revenue  (to-integer (get config :product-rate)))
   (evaluate (get employee :rate))))