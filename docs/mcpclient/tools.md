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
(mc/list-tools plumcp-client
               (fn [tools]
                 (println "Tools" tools)))
```

## Call tool

To call the tool defined in [Tools (Server)](../mcpserver/tools.md)
by name the call would be:

```clojure
(mc/call-tool plumcp-client
              "generate_demand_forecast"
              {"part_number" "4588-RT-345"
               :weeks 4}
              (fn [demand-forecast]
                (println demand-forecast)))
```

After you get the call-tool result, you can parse and destructure it to
suit your AI use case.

### Error handling

If an error is encountered when calling a tool, the error is printed
on the screen by default. To handle the error you can specify an error
response handler to the call:

```clojure
(mc/call-tool plumcp-client
              "generate_demand_forecast"
              {"part_number" "4588-RT-345"
               :weeks 4}
              (fn [demand-forecast]
                (println demand-forecast))
              (fn [jsonrpc-error-response]
                ;; handle the error
                (println jsonrpc-error-response)))
```

Unlike the result (data), the error handler receives the entire JSON-RPC
error response (map) - the error payload is located at the `:error` key.
