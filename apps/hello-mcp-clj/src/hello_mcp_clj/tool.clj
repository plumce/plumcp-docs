(ns hello-mcp-clj.tool
  (:require
   [plumcp.core.api.entity-gen :as eg]
   [plumcp.core.util :as u]))


(defn get-forecast
  [part-no weeks]
  ;; Call internal function to generate the data
  {:part-number "4588-RT-345"
   :description "O Ring Heat-resistant Grade-3"
   :quantity 28
   :denomination "each"})


(defn ^{:mcp-name "generate_demand_forecast"
        :mcp-type :tool} demand-forecast
  "Generate demand forecast for specified equipment"
  [{:keys [^{:name "part_number"
             :doc "Equipment part number" :type "string"} part-no
           ^{:doc "Forecast weeks count" :type "integer"
             :default 3 :minimum 1 :maximum 8} weeks]}]
  (let [fc (get-forecast part-no weeks)]
    (eg/make-call-tool-result
     [(eg/make-text-content (u/json-write fc))])))
