(ns inmogr-budget.team-numbers)
(defn teams-numbers
  [staff]
  (map staff
       (fn [employee]
         (get employee team))))