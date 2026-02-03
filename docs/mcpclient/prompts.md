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
(mc/list-prompts plumcp-client
                 (fn [prompts]
                   (println "Prompts" prompts)))
```

## Get prompt

To get the prompt defined in [Prompts (Server)](../mcpserver/prompts.md)
by name the call would be:

```clojure
(def query
  "What is the best way to learn about medicine as someone
  who has no background in medicine?")

(mc/get-prompt plumcp-client
               "chain_of_verification"
               {:query query}
               (fn [prompt-result]
                 (println prompt-result)))
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
               (fn [prompt-result]
                 (println prompt-result))
               (fn [jsonrpc-error-response]
                 ;; handle the error
                 (println jsonrpc-error-response)))
```

Unlike the result (data), the error handler receives the entire JSON-RPC
error response (map) - the error payload is located at the `:error` key.
