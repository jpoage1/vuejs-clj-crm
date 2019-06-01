(ns inmogr-budget.devs-weekly-wages
    (:refer [devWeeklyWages :refer [devWeeklyWages]]
            ))
(defn devs-weekly-wages
  [devs, productRate]
  (reduce +
          (map (fn [dev]
                 (dev-weekly-wages dev productRate))
               devs)))