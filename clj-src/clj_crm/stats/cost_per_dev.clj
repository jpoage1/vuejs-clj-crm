(ns clj-crm.stats.cost-per-dev
  )
(defn cost-per-dev
    [hours-per-deal wage]
    (* hours-per-deal wage))