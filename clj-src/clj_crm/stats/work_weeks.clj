(ns clj-crm.stats.work-weeks
	(:require [clj-crm.utilities.casting :refer [to-integer]]))
(defn work-weeks
  [employee]
  (- 52
     (to-integer (get employee :vacation))))