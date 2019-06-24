[js-budget-analyzer.team :refer [team]]
[js-budget-analyzer.teams-numbers :refer [teams-numbers]]

(defn teams
  [staff]
  (map
   (fn [team-no]
     (team staff team-no))
   (teams-numbers staff)))