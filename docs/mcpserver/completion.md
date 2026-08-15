---
icon: material/refresh-auto
---

# MCP Completion

A completion is meant to bring interactive experience to the user. The
user enters a part of prompt argument or resource template argument, and
the server offers autocompletion suggestions.

For example, a restaurant booking assistant may ask the user to enter
the cuisine name. If the user enters `ind`, the MCP completion may
respond with:

- Indian
- Indonesian
- North Indian
- South Indian

```clojure linenums="1" hl_lines="24-33"
--8<-- "apps/hello-mcp-clj/src/hello_mcp_clj/completion.clj"
```

Other arguments may be autocompleted in a similar manner. For resource
template argument reference, you need to use

```clojure
(eg/make-resource-template-reference "res://template-name")
```
