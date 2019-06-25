(ns clj-crm.stats.revenue
	(:require [clj-crm.utilities.casting :refer [to-integer]]))
(defn revenue
  [deals average-deal]

  (* (to-integer average-deal) (to-integer deals)))