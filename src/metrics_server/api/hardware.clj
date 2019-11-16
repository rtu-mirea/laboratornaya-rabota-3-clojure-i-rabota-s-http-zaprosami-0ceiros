(ns metrics-server.api.hardware
  (:require [metrics-server.core :refer [call-api check-required-params with-collection-format]])
  (:import (java.io File)))

(defn get-metrics-with-http-info
  "Get hardware metrics"
  []
  (call-api "/hardware" :get
            {:path-params   {}
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       []
             :auth-names    []}))

(defn get-metrics
  "Get hardware metrics"
  []
  (:data (get-metrics-with-http-info)))

;; Задание 1
(defn task1 [metrics]
  (filter (fn [a] (< (get a :cpuTemp) 2)) metrics)
  )
;; (metrics-server.api.hardware/task1 (metrics-server.api.hardware/get-metrics))

