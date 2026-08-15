(ns hello-mcp-clj.client.sampling
  (:require
   [plumcp.core.api.capability :as cap]
   [plumcp.core.api.entity-gen :as eg]
   [plumcp.core.api.mcp-runtime :as mr]
   [plumcp.core.schema.json-rpc :as jr]
   [plumcp.core.schema.schema-defs :as sd]))


(defn ^{:mcp-type :sampling
        :mcp-name "sampling-handler"} sampling-handler
  "Respond to sampling request from server"
  [{:as kwargs}]
  (let [;; fetch data, do computation etc
        model-name "..."
        message-text "..."]
    ;; any further
    (->> (eg/make-text-content message-text)
         (eg/make-create-message-result model-name sd/role-user)
         (jr/jsonrpc-success (mr/get-request-id kwargs)))))


(defn make-sampling-handler
  "Manual equivalent of creating a sampling handler as in the function
   `sampling-handler` above. There may be only one samplng handler per
   MCP client."
  []
  (cap/make-sampling-handler sampling-handler))
