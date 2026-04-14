---
icon: material/message-outline
---

# MCP Prompts (Client)

You can access the server-defined prompt templates using PluMCP client
API. It is assumed that you would require and alias the client namespace
as follows:

```clojure
[plumcp.core.api.mcp-client :as mc]
```

## List prompts

You can list the server-defined prompts using `list-prompts`:

```clojure
;; CLJ (JVM) returns a value
(let [prompts (mc/list-prompts plumcp-client)]
  (println "Prompts" prompts))

;; CLJS returns js/Promise
(-> (mc/list-prompts plumcp-client)
    (.then (fn [prompts]
             (println "Prompts" prompts))))
```

## Get prompt

To get the prompt defined in [Prompts (Server)](../mcpserver/prompts.md)
by name the call would be:

```clojure
(def query
  "What is the best way to learn about medicine as someone
  who has no background in medicine?")

;; CLJ (JVM) returns a value
(when-let [prompt-result (mc/get-prompt plumcp-client
                                        "chain_of_verification"
                                        {:query query})]
  (println prompt-result))

;; CLJS returns a js/Promise
(-> (mc/get-prompt plumcp-client
                   "chain_of_verification"
                   {:query query})
    (.then (fn [prompt-result]
             (when prompt-result
               (println prompt-result)))))
```

After you get the prompt result, you can use it to send a request to a
suitable AI language model.

### Error handling

If an error is encountered when getting a prompt, the error is printed
on the screen by default. To handle the error you can specify an error
response handler to the call:

```clojure
(mc/get-prompt plumcp-client
               "chain_of_verification"
               {:query query}
               {:on-error (fn [id jsonrpc-error]
                            ;; handle the error
                            (println "ERROR getting prompt"
                                     jsonrpc-error)
                            nil)})
```

The `:on-error` option is specified to use a handler for the error. Rest
is similar to result handling (CLJ vs CLJS difference remains as it is.)