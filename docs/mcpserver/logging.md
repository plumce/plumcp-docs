---
icon: material/math-log
---

# MCP Logging

MCP Server logging is meant to communicate to the client anything deemed
communicable from the server end. It may or may not be made accessible
to the user through the MCP client.

MCP Server API allows the following levels of logging:

| Index | Log Level | Meaning                          | Function        |
|-------|-----------|----------------------------------|-----------------|
|   0   | emergency | System is unusable               |`log-0-emergency`|
|   1   | alert     | Must take immediate action       |`log-1-alert`    |
|   2   | critical  | Critical conditions              |`log-2-critical` |
|   3   | error     | Error conditions                 |`log-3-error`    |
|   4   | warning   | Warning conditions               |`log-4-warning`  |
|   5   | notice    | Normal but significant condition |`log-5-notice`   |
|   6   | info      | Informational messages           |`log-6-info`     |
|   6   | debug     | Debug-level messages             |`log-7-debug`    |

## Code example

You may log inside any handler function for tool, prompt, resource or
completion. You need to pass the context (map) available in the kwargs:

```clojure linenums="1" hl_lines="11-12 14-17"
--8<-- "apps/hello-mcp-clj/src/hello_mcp_clj/logging.clj"
```

The `with-logger` macro sets the _logger_ to the specified name, which
gets included in every log entry emitted in that lexical scope.