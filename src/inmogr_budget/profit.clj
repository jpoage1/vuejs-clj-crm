(ns inmogr-budget.profit)
(defn profit
[rev, exp]
    (let [revenue (if (map? rev)
                      (reduce + rev)
                      rev)
    expenses (if (map? exp)
                 (reduce + exp)
                 exp)]
                 (- revenue expenses)))