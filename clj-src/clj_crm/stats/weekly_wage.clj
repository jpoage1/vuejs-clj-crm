(ns clj-crm.stats.weekly-wage
  (:require [clj-crm.stats.weekly-revenue :refer [weekly-revenue]]
            ))
(defn weekly-wage
  [employees employee deals average-deal helper]
  (helper employee
          (weekly-revenue employees employee deals average-deal)))