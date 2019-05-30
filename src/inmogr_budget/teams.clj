[inmogr-budget.team :refer [team]]
[inmogr-budget.teams-numbers :refer [teams-numbers]]
(defn teams
  [staff]
  (map
   (fn [team-no]
     (team staff team-no))
   (teams-numbers staff)))