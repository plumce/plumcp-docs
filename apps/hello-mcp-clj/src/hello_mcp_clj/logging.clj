(ns hello-mcp-clj.logging
  (:require
   [plumcp.core.api.mcp-server :as ms]
   [plumcp.core.deps.runtime :as rt]))


(defn handler-for-tool-prompt-or-resource
  "Handler fn for tool, prompt, resource, or completion."
  [{:as kwargs}]
  ;; ... other code ...
  (-> (rt/get-runtime kwargs)
      (ms/log-7-debug "debug log-message or map"))
  ;; ... other code ...
  (ms/with-logger [kwargs "discount-computation"]
    ;; ... other code ...
    (-> (rt/get-runtime kwargs)
        (ms/log-6-info "info log-message or map"))
    ;; ... other code ...
    )
  ;; ... other code
  )
