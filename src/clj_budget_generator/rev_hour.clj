(ns js-budget-analyzer.rev-hour
  (:require [js-budget-analyzer.revenue :refer [revenue]]
            [js-budget-analyzer.total-hours :refer [total-hours]]
            ))
(defn rev-hour
  [employees deals average-deal]

  (/
   (revenue deals average-deal)
   (total-hours employees)))