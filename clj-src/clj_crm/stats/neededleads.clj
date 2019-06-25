(ns clj-crm.stats.needed-leads
  (:require [clj-crm.stats.needed-coversions :refer [needed-coversions]]
            ))
(defn needed-leads
  [revenue average-deal conversion-to-deal lead-to-conversion]
  (/
   (needed-coversions revenue average-deal conversion-to-deal)
   lead-to-conversion))