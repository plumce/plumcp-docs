(ns hello-mcp-clj.client.elicitation
  (:require
   [plumcp.core.api.capability :as cap]
   [plumcp.core.api.entity-gen :as eg]
   [plumcp.core.schema.schema-defs :as sd]))


(defn ^{:mcp-type :elicitation} elicitation-handler
  [{:as kwargs}]
  (let [;; ...ask user input...
        input {:airport "BOM"
               :name "Mumbai"}
        result (eg/make-elicit-result sd/elicit-action-accept
                                      {:content input})]
    result))


(defn make-elicitation-handler
  "This is the manual equivalent of creating an elicitation handler as
   in the `elicitation-handler` function above."
  []
  (cap/make-elicitation-handler elicitation-handler))
