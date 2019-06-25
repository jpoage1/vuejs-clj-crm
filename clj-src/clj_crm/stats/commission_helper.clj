(ns clj-crm.stats.commission-helper
  (:require [clj-crm.utilities.math :refer [evaluate]]
	 [clj-crm.utilities.casting :refer [to-integer]]))
(defn commission-helper
  [employee revenue]

  (* (to-integer revenue)
     (evaluate (get employee :rate))))