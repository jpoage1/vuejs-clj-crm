(ns inmogr-budget.data.staff
  (:require [inmogr-budget.data.labels :refer [manager developer sdr]]))
(def staff [{:id 1
             :name nil
             :team nil
             :role manager
             :vacation 4 ; In Weeks
             :rate 50 ; Dollars Per Hour
             :hours 40}
      {:id 2
       :name nil
       :team 1 ; Team number is the product manager's id
       :role developer
       :vacation 4
       :rate "6/10*150"
       :hours 40}
      {:id 3
       :name nil
       :team 1
       :role developer
       :vacation 4
       :rate "6/10*150"
       :hours 40}
      {:id 4
       :name "Jason"
       :team 1
       :role sdr
       :vacation 4
       :rate "15/100"
       :hours 40}])