(ns js-budget-analyzer.needed-conversions
    (:require [js-budget-analyzer.needed-deals :refer [needed-deals]]
              ))
(defn needed-coversions
  [revenue averageDeal conversionToDeal]
  (/
   (neededDeals revenue averageDeal)
   conversionToDeal))