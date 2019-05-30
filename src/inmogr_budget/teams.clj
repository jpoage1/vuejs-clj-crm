[inmogr-budget.team :refer [team]]
[inmogr-budget.teams-numbers :refer [teams-numbers]]
(defn teams
  [staff]
  (map
   (teams-numbers staff)
   (fn [team-no]
     (team staff team-no))))