(ns inmogr-budget.rev-hour
  (:require [inmogr-budget.revenue :refer [revenue]]
            [inmogr-budget.total-hours :refer [total-hours]]
            ))
(defn rev-hour
  [employees deals average-deal]
  (prn 'rev-hour (revenue deals average-deal) (total-hours employees))
  (/
   (revenue deals average-deal)
   (total-hours employees)))