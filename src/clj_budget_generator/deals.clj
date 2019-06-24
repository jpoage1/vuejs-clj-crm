(ns js-budget-analyzer.deals)
(defn deals
  [annual-revenue average-deal]
  (/ annual-revenue average-deal))