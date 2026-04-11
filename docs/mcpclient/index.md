# PluMCP Client

The PluMCP client workflow:

```mermaid
flowchart TD
    Start@{ shape: circle, label: "Start" }
    A@{ shape: rounded, label: "1. Make PluMCP client" }
    B@{ shape: rounded, label: "2. Initialize" }
    C@{ shape: rounded, label: "3. MCP client operation" }
    D@{ shape: rounded, label: "4. Disconnect" }
    Stop@{ shape: dbl-circ, label: "Stop" }
    Start-->A
    A-->|Transport is started|B
    B-->|Session is established|C
    C-->|Next MCP Client Operation| C
    C-->|Want to end the client|D
    D-->|Session/Transport is stopped|Stop
```

The PluMCP Client API is contained in the `plumcp.core.api.mcp-client`
namespace. Remainder of this page assumes you have these aliases setup.

```clojure
(ns app.core
  (:require [plumcp.core.api.entity-support :as es]
            [plumcp.core.api.mcp-client :as mc]
            [plumcp.core.client.http-client-transport :as hct]
            [plumcp.core.client.stdio-client-transport :as sct]
            [plumcp.core.support.http-client :as hc]))
```


## 1. Make PluMCP client

```clojure
(def client-info (es/make-info "My MCP app" "0.1.0"))

(def stdio-transport
  (sct/run-command {:command-tokens ["run-mcp-server"]}))

(def http-transport
  (hct/make-streamable-http-transport
   (hc/make-http-client "http://localhost:3000/mcp")))

(def client-transport http-transport)  ; or stdio-transport

(def the-client (mc/make-client {:info client-info
                                 :client-transport client-transport}))
```

## 2. Initialize the client

MCP client initialization needs to be followed up with a notification
of initialization, which you can do together as follows:

```clojure
(mc/initialize-and-notify! the-client)
```

## 3. MCP Client operation

The MCP Client operations have their corresponding API. Some of the API
calls that accept client and a handler function as argument are shown
below:

### 3.1 Listing primitives

| MCP Client Operation        | Client API call              | Arguments         |
|-----------------------------|------------------------------|-------------------|
| List MCP prompts            | `mc/list-prompts`            | `[client & opts]` |
| List MCP resources          | `mc/list-resources`          | `[client & opts]` |
| List MCP resource templates | `mc/list-resource-templates` | `[client & opts]` |
| List MCP tools              | `mc/list-tools`              | `[client & opts]` |

### 3.2 Individual primitive operation

| MCP Client Operation  | Client API call    | Arguments                       |
|-----------------------|--------------------|---------------------------------|
| Get MCP prompt        | `mc/get-prompt`    | `[client p-name p-args & opts]` |
| Read MCP resource     | `mc/read-resource` | `[client resource-uri  & opts]` |
| Call MCP tool         | `mc/call-tool`     | `[client t-name t-args & opts]` |
| Complete (Completion) | `mc/complete`      | `[client comp-request  & opts]` |
| Ping                  | `mc/ping`          | `[client               & opts]` |

!!! note "Note!"

    This is a selected list of API calls - for exhaustive list check the
    source in `plumcp.core.api.mcp-client` namespace.

For example, you can print the list the MCP tools as follows:

```clojure
;; In Clojure (JVM) it returns a value
(let [tools (mc/list-tools the-client)]
  (println "Tools" tools))

;; In CLJS it returns a js/Promise
(-> (mc/list-tools the-client)
    (.then (fn [tools]
             (println "Tools" tools))))
```

## 4. Disconnect the client

Disconnection of the client, which stops the transport, is quite
straightforward:

```clojure
(mc/disconnect! the-client)
```

!!! warning "Don't forget to disconnect"

    Failing to disconnect the PluMCP client may keep the client
    transport running, holding on to resources, hence preventing
    cleanup.