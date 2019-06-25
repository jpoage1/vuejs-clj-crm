(ns clj-crm.stats.deals)
(defn deals
  [annual-revenue average-deal]
  (/ annual-revenue average-deal))