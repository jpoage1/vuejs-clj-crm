(ns clj-crm.stats.hours-per-dev
  )
(defn hours-per-dev
    [costPerDev wage]
    (/ costPerDev wage))