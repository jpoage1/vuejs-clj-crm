(ns inmogr-budget.needed-leads
  (:require [inmogr-budget.needed-coversions :refer [needed-coversions]]
            ))
(defn needed-leads
  [revenue average-deal conversion-to-deal lead-to-conversion]
  (/
   (needed-coversions revenue average-deal conversion-to-deal)
   lead-to-conversion))