(ns inmogr-budget.test-parse-stats
  (require [inmogr-budget.stats :refer [parse-stats evaluate-config] :reload-all true]
           [inmogr-budget.data.config :refer [config] :reload-all true]
            [clojure.data.json :as json]
           [inmogr-budget.data.staff :refer [staff] :reload-all true]))
(def data "{
    \"staff\": [
        {
            \"id\": \"1\",
            \"name\": \"\",
            \"team\": \"\",
            \"role\": \"1\",
            \"vacation\": \"4\",
            \"rate\": \"50\",
            \"hours\": \"40\"
        },
        {
            \"id\": \"2\",
            \"name\": \"\",
            \"team\": \"1\",
            \"role\": \"2\",
            \"vacation\": \"4\",
            \"rate\": \"6/10*150\",
            \"hours\": \"40\"
        },
        {
            \"id\": \"3\",
            \"name\": \"\",
            \"team\": \"1\",
            \"role\": \"2\",
            \"vacation\": \"4\",
            \"rate\": \"6/10*150\",
            \"hours\": \"40\"
        },
        {
            \"id\": \"4\",
            \"name\": \"Jason\",
            \"team\": \"1\",
            \"role\": \"3\",
            \"vacation\": \"4\",
            \"rate\": \"15/100\",
            \"hours\": \"40\"
        }
    ],
    \"config\": [
        {
        				\"full-time\": \"40\",
            \"average-deal\": \"3500\",
            \"product-rate\": \"150\",
            \"prospect-to-lead\": \"1/10\",
            \"lead-to-qualified\": \"1/10\",
            \"qualified-to-sale\": \"1/10\"
        } 
    ]
}")

(let [{config :config
       staff :staff} (json/read-json data)
      evaluated-config (evaluate-config config)]
  (json/write-str (parse-stats evaluated-config staff)))