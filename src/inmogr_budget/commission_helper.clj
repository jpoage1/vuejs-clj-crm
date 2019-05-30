(ns inmogr-budget.commission-helper)
(defn commission-helper
  [employee revenue]
  (* revenue (get employee :rate)))