(ns hello-mcp-clj.prompt
  (:require
   [plumcp.core.api.entity-gen :as eg]
   [plumcp.core.schema.schema-defs :as sd]))


(def cove-steps
  "Step 1. Provide your initial answer
Step 2. Generate 3 to 5 sub-questions that would test the main answer's facts
Step 3. Provide answers to each of those verification questions on their own
Step 4. Provide a revised answer to the original question based on those checks
")


;; Ref: https://arxiv.org/abs/2309.11495
;; YTV: https://www.youtube.com/watch?v=MKU-Aeg_lBk
(defn ^{:mcp-name "chain_of_verification"
        :mcp-type :prompt} cove
  "Generate a Chain of Verification (CoVe) prompt for a given query."
  [{:keys [^{:doc "User query"
             :type "string"} query]}]
  (eg/make-get-prompt-result
   [(eg/make-prompt-message
     sd/role-user
     (eg/make-text-content
      (str query
           "\n"
           cove-steps)))]))
