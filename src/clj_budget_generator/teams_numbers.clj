(ns js-budget-analyzer.team-numbers
  )
(defn teams-numbers
  [staff]
  (map
   (fn [employee]
     (get employee team))
   staff))