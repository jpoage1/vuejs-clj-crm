(ns inmogr-budget.utilities.casting
  (:require [inmogr-budget.utilities.math :as math]))
(defn to-integer [n]

  (if (or (integer? n) (ratio? n))
    n
    (Integer/parseInt n)))
(defn evaluate [n]
  (if (integer? n)
    n
    (math/evaluate n)))