(ns inmogr-budget.stats
  (:require [inmogr-budget.goals :refer [goals] :reload true]
            [inmogr-budget.employee-stats :refer [employee-stats] :reload true]
            [inmogr-budget.db.read-config :refer [read-config]]
            [inmogr-budget.data.staff :refer [staff] :reload true]
            [inmogr-budget.data.config :refer [config] :reload true]
            [inmogr-budget.db.read-staff :refer [read-staff]]
            [inmogr-budget.send-json :refer [send-json]]
            [ring.util.request :refer [body-string]]))
(defn parse-stats
  [config staff]
  (let [company-goals (goals config staff)];
    {; Calculates how much in total it costs to keep devs happy and busy
     :company-goals company-goals
     ; Goals for specific employees set based on information stored in staff variables
     :employee-goals (map employee-stats company-goals)}))

(defn lookup
  [stack match-key id]
  (map (fn [x]
         (= id (get x match-key))
         stack)))

; mannual lookup in data file
(defn lookup-stats
[config-id team-id]
  (let [config (lookup config :id config-id)
        staff (lookup staff :team team-id)]
  (send-json (parse-stats config staff))))


; db lookup
(defn query-stats
[config-id team-id]
  (let [config (read-config config-id)
        staff (read-staff team-id)]
  (send-json (parse-stats config staff))))

; get config-id and team-id from request
(defn read-stats
[request]
  (let [{config-id :config
         team-id :team} (body-string request)]
  (send-json (lookup-stats config-id team-id))))

