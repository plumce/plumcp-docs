---
icon: material/tools
---

# MCP Tools (Client)

You can access the server-defined tools using PluMCP client
API. It is assumed that you would require and alias the client namespace
as follows:

```clojure
[plumcp.core.api.mcp-client :as mc]
```

## List tools

You can list the server-defined tools using `list-tools`:

```clojure
;; In CLJ (JVM) this returns a value
(let [tools (mc/list-tools plumcp-client)]
  (println "Tools" tools))

;; In CLJS this returns a js/Promise
(-> (mc/list-tools plumcp-client)
    (.then (fn [tools]
             (println "Tools" tools))))
```

## Call tool

To call the tool defined in [Tools (Server)](../mcpserver/tools.md)
by name the call would be:

```clojure
;; In CLJ (JVM) this returns a value
(let [result (mc/call-tool plumcp-client
                           "generate_demand_forecast"
                           {"part_number" "4588-RT-345"
                            :weeks 4})]
  (println "Demand forecast:" result))

;; In CLJS this returns a js/Promise
(-> (mc/call-tool plumcp-client
                  "generate_demand_forecast"
                  {"part_number" "4588-RT-345"
                   :weeks 4})
    (.then (fn [result]
             (println "Demand forecast:" result))))
```

After you get the call-tool result, you can parse and destructure it to
suit your AI use case.

### Error handling

If an error is encountered when calling a tool, the error is printed
on the screen by default. To handle the error you can specify an error
handler to the call:

```clojure
(mc/call-tool plumcp-client
              "generate_demand_forecast"
              {"part_number" "4588-RT-345"
               :weeks 4}
              {:on-error (fn [id jsonrpc-error]
                           (println "ERROR calling tool"
                                    jsonrpc-error)
                           nil)})
```

The `:on-error` option is specified to use a handler for the error. Rest
is similar to result handling (CLJ vs CLJS difference remains as it is.)