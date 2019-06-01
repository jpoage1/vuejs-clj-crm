(ns inmogr-budget.manager-weekly-wages
  (:require [inmogr-budget.devs-weekly-revenue :refer [devs-weekly-revenue]]
            [inmogr-budget.sdrs-weekly-wages :refer [sdrs-weekly-wages]]
            [inmogr-budget.devs-weekly-wages :refer [devs-weekly-wages]]
            ))
(defn manager-weekly-wages
  [devs sdrs product-rate]
  (let [difference (devs-weekly-revenue devs product-rate)
        (sdrs-weekly-wages devs product-rate sdrs)
        (devs-weekly-wages devs)]
    (reduce - difference)))