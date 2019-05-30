(ns inmogr-budget.devs-weekly-wages
    (:refer [devWeeklyWages :refer [devWeeklyWages]]))
(defn devs-weekly-wages
  [devs, productRate]
  (reduce + (map devs (fn [dev] (dev-weekly-wages dev, productRate)))))