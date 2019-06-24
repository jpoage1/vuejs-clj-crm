(ns js-budget-analyzer.manager-weekly-wages
  (:require [js-budget-analyzer.devs-weekly-revenue :refer [devs-weekly-revenue]]
            [js-budget-analyzer.sdrs-weekly-wages :refer [sdrs-weekly-wages]]
            [js-budget-analyzer.devs-weekly-wages :refer [devs-weekly-wages]]
            ))
(defn manager-weekly-wages
  [devs sdrs product-rate]
  (let [difference (devs-weekly-revenue devs product-rate)
        (sdrs-weekly-wages devs product-rate sdrs)
        (devs-weekly-wages devs)]
    (reduce - difference)))