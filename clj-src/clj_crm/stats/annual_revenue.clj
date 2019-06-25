(ns clj-crm.stats.annual-revenue 
    (:require [clj-crm.stats.rev-hour :refer [rev-hour]]
	 [clj-crm.utilities.casting :refer [to-integer]]))
(defn annual-revenue
  [employees employee deals average-deal]

  (* (rev-hour employees deals average-deal)
     (to-integer (get employee :hours))))