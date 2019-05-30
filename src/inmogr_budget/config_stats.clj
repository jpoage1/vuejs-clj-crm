(ns inmogr-budget.config-stats
    (:require  [inmogr-budget.data.labels  :refer [developer sdr manager]]
[inmogr-budget.staff-by-role :refer [staff-by-role]]
[inmogr-budget.devs-annual-revenue :refer [devs-annual-revenue] :reload true]
[inmogr-budget.devs-weekly-revenue :refer [devs-weekly-revenue]]))
(defn config-stats
    [config staff]
    (let [ devs (staff-by-role staff developer)
          annual-revenue (devs-annual-revenue devs (get config :product-rate))
          weekly-revenue (devs-weekly-revenue devs (get config :product-rate))
          ]
    (merge config {
        :annual-revenue annual-revenue
        :monthly-revenue (/ annual-revenue 12)
        :weekly-revenue weekly-revenue
        :daily-revenue (/ weekly-revenue 5)
    })))