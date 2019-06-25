(ns clj-crm.stats.weekly-revenue
  (:require [clj-crm.stats.annual-revenue :refer [annual-revenue]]
            [clj-crm.stats.work-weeks :refer [work-weeks]]
            ))
(defn weekly-revenue
  [employees employee deals average-deal]
  (/ (annual-revenue employees employee deals average-deal)
     (work-weeks employee)))