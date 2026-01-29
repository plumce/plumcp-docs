(ns hello-mcp-clj.core
  (:require [plumcp.core.api.entity-support :as es]
            [plumcp.core.api.mcp-server :as ms])
  (:gen-class))

(def info (es/make-info "Hello MCP Server" "0.1.0"))

(defn ^{:mcp-type :tool} add
  "Add two integers"
  [{:keys [^{:doc "An integer" :type "integer"} a
           ^{:doc "Another integer" :type "integer"} b]}]
  (str "Sum of " a " and " b " is " (+ a b)))

(defn -main
  [& args]
  (ms/run-server {:info info :transport :http}))
