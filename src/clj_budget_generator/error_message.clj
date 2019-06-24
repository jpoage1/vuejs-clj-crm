(ns js-budget-analyzer.error-message
  (:require [js-budget-analyzer.send-json :refer [send-json]]
            ))
(def error-message (send-json "Error" 404))