---
icon: material/file-tree-outline
---

# MCP Roots

!!! warning "Deprecation Notice"

    Roots feature has been deprecated in the MCP spec 2026-07-28.

    You are advised NOT to adopt this for new projects.

MCP Roots are locations relevant for the client's tasks and domain. The
server (prompt, resource or tool handlers) may ask for a list of roots
in order to produce results.

## Code example

```clojure linenums="1" hl_lines="8 13 18"
--8<-- "apps/hello-mcp-clj/src/hello_mcp_clj/client/roots.clj"
```
