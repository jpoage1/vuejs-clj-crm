(ns clj-crm.stats.revenue-per-dev
  )
(defn revenuePerDev
  [revenue, no-of-devs]
  (/ revenue no-of-devs))