(ns inmogr-budget.cost-per-sdr)
(defn cost-per-sdr
  [revenue, wage]
  (* revenue wage))