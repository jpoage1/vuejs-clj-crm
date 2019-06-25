(ns clj-crm.stats.annual-wage
  (:require [clj-crm.stats.annual-revenue :refer [annual-revenue]]
            ))
(defn annual-wage
  [employees employee deals average-deal helper]

  (helper employee (annual-revenue employees employee deals average-deal)))