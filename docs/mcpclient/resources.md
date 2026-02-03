---
icon: material/file-document-outline
---

# MCP Resources (Client)

You can access the server-defined resources and resource-templates using
PluMCP client API. It is assumed that you would require and alias the
client namespace as follows:

```clojure
[plumcp.core.api.mcp-client :as mc]
```

## List resources and resource-templates

You can list the server-defined resources using `list-resources` and
resource-templates using `list-resource-templates`:

```clojure
(mc/list-resources plumcp-client
                   (fn [resources]
                     (println "Resources" resources)))

(mc/list-resource-templates plumcp-client
                            (fn [resource-templates]
                              (println "Resource templates"
                                       resource-templates)))
```


## Read resource

To read the resource defined in [Resources (Server)](../mcpserver/resources.md)
by name the call would be:

```clojure
(mc/read-resource plumcp-client
                  "text://fire/safety"
                  (fn [resource-result]
                    (println resource-result)))

(mc/read-resource plumcp-client
                  "info://consumable/148"
                  (fn [resource-result]
                    (println resource-result)))
```

### Error handling

If an error is encountered when reading a resource, the error is printed
on the screen by default. To handle the error you can specify an error
response handler to the call:

```clojure
(mc/read-resource plumcp-client
                  "info://consumable/148"
                  (fn [resource-result]
                    (println resource-result))
                  (fn [jsonrpc-error-response]
                    ;; handle the error
                    (println jsonrpc-error-response)))
```

Unlike the result (data), the error handler receives the entire JSON-RPC
error response (map) - the error payload is located at the `:error` key.
