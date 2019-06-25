(ns clj-crm.stats.rev-hour
  (:require [clj-crm.stats.revenue :refer [revenue]]
            [clj-crm.stats.total-hours :refer [total-hours]]
            ))
(defn rev-hour
  [employees deals average-deal]

  (/
   (revenue deals average-deal)
   (total-hours employees)))