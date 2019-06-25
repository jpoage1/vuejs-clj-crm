[clj-crm.stats.team :refer [team]]
[clj-crm.stats.teams-numbers :refer [teams-numbers]]

(defn teams
  [staff]
  (map
   (fn [team-no]
     (team staff team-no))
   (teams-numbers staff)))