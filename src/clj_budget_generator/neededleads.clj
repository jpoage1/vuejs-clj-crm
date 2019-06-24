(ns js-budget-analyzer.needed-leads
  (:require [js-budget-analyzer.needed-coversions :refer [needed-coversions]]
            ))
(defn needed-leads
  [revenue average-deal conversion-to-deal lead-to-conversion]
  (/
   (needed-coversions revenue average-deal conversion-to-deal)
   lead-to-conversion))