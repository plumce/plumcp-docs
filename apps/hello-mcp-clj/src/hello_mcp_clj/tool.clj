(ns hello-mcp-clj.tool
  (:require
   [plumcp.core.api.capability :as cap]
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


(defn ^{:see [cap/primitives->server-capabilities]}
  make-tool-get-demand-forecast
  "Manual equivalent of defining a tool with handler as in the
   `demand-forecast` function above. Several such tool items may
   be used together as server-side tools capability."
  []
  (let [in-schema (-> {"part_number" {:type "string"
                                      :description "Equipment part number"}
                       "weeks" {:type "integer"
                                :description "Forecast weeks count"
                                :required? false
                                :default 3 :minimum 1 :maximum 8}}
                      (eg/make-tool-input-output-schema ["part_number"]))
        tool-doc  "Generate demand forecast for specified equipment"
        f-handler (fn [{part-no :part_number
                        weeks :weeks}]
                    (let [fc (get-forecast part-no weeks)]
                      (eg/make-call-tool-result
                       [(eg/make-text-content (u/json-write fc))])))]
    (cap/make-tool-item "generate_demand_forecast" in-schema
                        f-handler
                        {:description tool-doc})))
