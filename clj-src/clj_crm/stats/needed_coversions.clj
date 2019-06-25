(ns clj-crm.stats.needed-conversions
    (:require [clj-crm.stats.needed-deals :refer [needed-deals]]
              ))
(defn needed-coversions
  [revenue averageDeal conversionToDeal]
  (/
   (neededDeals revenue averageDeal)
   conversionToDeal))