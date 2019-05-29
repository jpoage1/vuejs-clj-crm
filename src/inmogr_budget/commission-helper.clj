(ns inmogr-budget.commissions-helper)
(defn commission-helper
  [employee revenue]
  (* revenue (get employee :rate)))