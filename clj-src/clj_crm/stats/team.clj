(ns clj-crm.stats.team
  )
(defn team
    [staff, team]
    (vec (if (is-map team)
        (filter
            (fn [employee]
                (or
                 (not=
                  (index-of team
                            (get employee :team)
                            -1))
                 (not=
                  (index-of team
                            (get employee :id))
                  -1)))
        staff)
        (filter
            (fn [employee]
                (or
                 (=
                  (get employee :team)
                  team)
                 (=
                  (get employee :id)
                  team)))))))