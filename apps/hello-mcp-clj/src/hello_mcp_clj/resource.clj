(ns hello-mcp-clj.resource
  (:require
   [plumcp.core.api.entity-support :as es]
   [plumcp.core.util :as u]))


(defn get-fire-safety-instructions []
  ;; Simulate loading fire safety instructions from storage
  "Fire safety instructions")


(defn ^{:mcp-type :resource
        :mcp-name "fire_safety_instructions"
        :mime-type "text/plain"} fire-safety
  "Fire safety instructions for the shopfloor"
  [{:keys [^{:doc "text://fire/safety"} uri]}]
  (es/make-text-resource-result
   uri
   (get-fire-safety-instructions)))


(defn get-consumable-info [id]
  ;; Simulate load consumable info from database
  {:part-no "ABC123"
   :description "Disinfectant wipe"
   :batch-no "56/2024"
   :life-upto "2025/06"})


(defn ^{:mcp-type :resource-template
        :mcp-name "consumable_info"
        :mime-type "application/json"} consumable-info
  "Consumable info as JSON"
  [{:keys [^{:doc "info://consumable/{id}"} uri
           ^{:doc "URI params"} params]}]
  (->> (get-consumable-info (:id params))
       u/json-write
       (es/make-text-resource-result uri)))
