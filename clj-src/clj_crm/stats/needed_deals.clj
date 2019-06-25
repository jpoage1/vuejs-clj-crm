(ns clj-crm.stats.needed-deals
  )
(defn needed-deals
  [revenue average-deal]
  (/ revenue average-deal))