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

### Clojure

In Clojure (JVM) `list-resources` and `list-resource-templates` return
a value.

```clojure
(let [resources (mc/list-resources plumcp-client)]
  (println "Resources" resources))

(let [templates (mc/list-resource-templates plumcp-client)]
  (println "Resource templates" resource-templates))
```

### ClojureScript

In ClojureScript `list-resources` and `list-resource-templates` return
a js/Promise, so we need to chain through the value.

```clojure
(-> (mc/list-resources plumcp-client)
    (.then (fn [resources]
             (println "Resources" resources))))

(-> (mc/list-resource-templates plumcp-client)
    (.then (fn [templates]
             (println "Resource templates" templates))))
```

## Read resource

To read the resource defined in [Resources (Server)](../mcpserver/resources.md)
by name the call would be:

### Clojure

In Clojure `read-resource` returns a value.

```clojure
(let [resource (mc/read-resource plumcp-client
                                 "text://fire/safety")]
  (println resource))

(let [resource (mc/read-resource plumcp-client
                                 "info://consumable/148")]
  (println resource))
```

### ClojureScript

In ClojureScript `read-resource` returns a `js/Promise`.

```clojure
(-> (mc/read-resource plumcp-client
                      "text://fire/safety")
    (.then (fn [resource]
             (println resource))))

(-> (mc/read-resource plumcp-client
                      "info://consumable/148")
    (.then (fn [resource]
             (println resource))))
```

### Error handling

If an error is encountered when reading a resource, the error is printed
on the screen by default. To handle the error you can specify an error
handler to the call:

```clojure
(mc/read-resource plumcp-client
                  "info://consumable/148"
                  {:on-error (fn [id jsonrpc-error]
                               (println "ERROR reading resource"
                                        jsonrpc-error)
                               nil)})
```

The `:on-error` option is specified to use a handler for the error. Rest
is similar to result handling (CLJ vs CLJS difference remains as it is.)