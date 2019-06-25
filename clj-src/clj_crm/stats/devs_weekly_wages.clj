(ns clj-crm.stats.devs-weekly-wages
    (:refer [dev-weekly-wages :refer [dev-weekly-wages]]
            ))
(defn devs-weekly-wages [devs, product-rate]
    (reduce +
            (map
             (fn [dev] (dev-weekly-wages dev product-rate)
               devs)))