(ns inmogr-budget.needed-conversions
    (:require [inmogr-budget.needed-deals :refer [needed-deals]]))
(defn needed-coversions
  [revenue averageDeal conversionToDeal]
  (/
   (neededDeals revenue averageDeal)
   conversionToDeal))