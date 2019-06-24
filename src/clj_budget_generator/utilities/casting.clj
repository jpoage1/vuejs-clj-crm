(ns js-budget-analyzer.utilities.casting
  (:require [js-budget-analyzer.utilities.math :as math]))
(defn to-integer [n]

  (if (or (integer? n) (ratio? n))
    n
    (Integer/parseInt n)))
(defn evaluate [n]
  (if (integer? n)
    n
    (math/evaluate n)))