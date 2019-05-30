(ns inmogr-budget.is-map)
(defn is-map
[x]
    (let [not-vector (if (vector? x) false true)
          is-map (if (map? x) true false)]
      (= is-map is-vector))