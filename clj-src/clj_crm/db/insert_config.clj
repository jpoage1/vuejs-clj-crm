(ns clj-crm.db.insert-config
  (:require [clj-crm.db.wrappers :refer [insert] :reload true]))
(defn parse-config
  "This function is practically useless at the moment, until I get into data validation.
Its primary puprose at the moment is to assure the correct arguments are passed to the database"
  [{:keys [id average_deal product_rate prospect_to_lead lead_to_sale qualified_to_sale]}]
  {:id id
   :average_deal :int
   :product_rate :int
   :prospect_to_lead :int
   :lead_to_sale :int
   :qualified_to_sale :int}
  {:id id
   :average_deal average_deal
   :product_rate product_rate
   :prospect_to_lead prospect_to_lead
   :lead_to_sale lead_to_sale
   :qualified_to_sale qualified_to_sale})
(defn insert-config
  [config]
  (insert! :config (parse-config config)))
  ;(insert :config (if (map? config) (map parse-config config) (parse-config config))))
(def regex {:integer 'integer
            :decimal 'decimal
            :absolute 'absolute
            :percent 'percent
            :alphanumeric 'alphanumeric
            :email 'email
            :uri 'uri})
(def config {[:id [:absolute :integer]]
             [:average_deal [:absolute :decimal]]
             [:product_rate [:absolute :decimal]]
             [:prospect_to_lead [:absolute :percent]]
             [:lead_to_sale [:absolute :percent]]
             [:qualified_to_sale [:absolute :percent]]})


(defn key-match [struct]
  "Find the struct that matches the data name
   The first column in for data and it's struct should be the data name.
   data passed to this function should only be a single data vector"
  (fn [data]
    (let [key (first data)
          struct (first (filter #(= % key) struct))])))




;;;; yeah im not so sure this does what i wanted it to do... 
(defn max [max data]
  "return true if not a match"
  (> max (second data)))
(defn validate [struct data]
  "validates a single data vector against a struct
   The first column in a struct should be the data name.
   The second column in a struct should be a vector of data types.
   The vector must contain a regex expression to match against.
   Every odd column thereafter, 3, 5 7, etc. should be a function
   That takes takes exactly two arguments:the value of the following
   column in the struct (3 4) (5 6) (7 8) etc.
   And the value of tha data being validated.
   After filtering through all of the functions,
   a result of 0 means success."
  (let [struct (filter (key-match struct) data) ; get the struct we are matching against
        key (first data)
        type (second struct)
        options (nthrest struct 2)
        options (partition 2 options)]
    (filter (fn [option]
              (let [f (first option)
                    a (second option)]
               (when (false? (f a data)) )) options)))