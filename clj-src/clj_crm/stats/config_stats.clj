(ns clj-crm.stats.config-stats
    (:require  [clj-crm.data.labels  :refer [developer sdr manager]]
               [clj-crm.stats.staff-by-role :refer [staff-by-role]]
               [clj-crm.stats.devs-annual-revenue :refer [devs-annual-revenue] :reload true]
               [clj-crm.stats.devs-weekly-revenue :refer [devs-weekly-revenue]]
               ))
(defn config-stats
  [config staff]
  (let [ devs (staff-by-role staff developer)
        annual-revenue (devs-annual-revenue config devs)
        weekly-revenue (devs-weekly-revenue config devs)
        ]
    (merge config {:annual-revenue annual-revenue
                   :monthly-revenue (/ annual-revenue 12)
                   :weekly-revenue weekly-revenue
                   :daily-revenue (/ weekly-revenue 5)
                   })))