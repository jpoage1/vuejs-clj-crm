(ns js-budget-analyzer.stats
  (:require [js-budget-analyzer.goals :refer [goals] :reload true]
            [js-budget-analyzer.employee-stats :refer [employee-stats] :reload true]
            [js-budget-analyzer.db.read-config :refer [read-config]]
            [js-budget-analyzer.data.staff :refer [staff] :reload true]
            [js-budget-analyzer.data.config :refer [config] :reload true]
            [js-budget-analyzer.db.read-staff :refer [read-staff]]
            [js-budget-analyzer.send-json :refer [send-json]]
            [js-budget-analyzer.utilities.math :refer [evaluate]]
            [clojure.data.json :as json]
            [ring.util.request :refer [body-string]]
            ))
(defn parse-stats
  [config staff]
  (let [company-goals (goals config staff)];
    {; Calculates how much in total it costs to keep devs happy and busy
     :company-goals company-goals
      ;Goals for specific employees set based on information stored in staff variables
     :employee-goals (map (fn [config] (employee-stats config staff)) company-goals)
     })
  )

(defn lookup
  [stack match-key id]
  (map (fn [x]
         (= id (get x match-key)))
         stack))

; mannual lookup in data file
(defn stats-lookup
[config-id team-id]
  (let [config (lookup config :id config-id)
        staff (lookup staff :team team-id)]
  (send-json (parse-stats config staff))))


; db lookup
(defn stats-query
[config-id team-id]
  (let [config (read-config config-id)
        staff (read-staff team-id)]
  (send-json (parse-stats config staff))))

(defn evaluate-config [all-configs]
    (map (fn [config]
         (into {}
               (map
                (fn [[k v]]
                  [k (evaluate v)])) config))
       all-configs))

; stats sent via post request
(defn stats-read
  [request]
  (let [{config :config
         staff :staff} (json/read-json (body-string request))
        evaluated-config (evaluate-config config)]
    (send-json (parse-stats evaluated-config staff))))

; get config-id and team-id from request
(defn handle-stats
  [request method]
  (let [{config-id :config
         team-id :team} (body-string request)]
    (send-json (method config-id team-id))))

(defn query-stats [request]
  (handle-stats request stats-query))
(defn lookup-stats [request]
  (handle-stats request stats-lookup))
(defn read-stats [request]
  (stats-read request)
  )

