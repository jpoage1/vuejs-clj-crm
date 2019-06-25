(ns clj-crm.stats.employee-stats
  (:require [clj-crm.data.labels :refer [developer sdr manager]]
            [clj-crm.stats.employee-stat :refer [employee-stat] :reload true]
            [clj-crm.stats.staff-by-role :refer [staff-by-role]]
            [clj-crm.stats.deals :refer [deals]]
	 [clj-crm.utilities.casting :refer [to-integer]]))
(defn employee-stats
  [config staff]
  (let [{annual-revenue :annual-revenue
         average-deal :average-deal} config
        d (deals annual-revenue average-deal)
        employees {manager (staff-by-role staff manager)
                   developer (staff-by-role staff developer)
                   sdr (staff-by-role staff sdr)}]
    (map (fn [employee]
           (let [employee-role (to-integer (get employee :role))
           						employees-by-role (get employees employee-role)]



             (employee-stat config employees-by-role employee d)))
         staff)))