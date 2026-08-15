---
icon: material/robot-outline
---

# MCP Sampling

!!! warning "Deprecation Notice"

    Sampling feature has been deprecated in the MCP spec 2026-07-28.

    You are advised NOT to adopt this for new projects.

Sampling lets an MCP server ask the AI model used by the
client a question or work out details toward any particular
goal.

!!! abstract "Example scenario"

    Imagine an insurance company is using an AI agent. They want to know
    if a certain car insurance claim needs deeper analysis. The AI agent
    connects to an MCP server that has access to company's claims.

    The server retrieves customer's current and previous claims, accident
    details, repair estimate and policy information. However, the server
    cannot do any reasoning by itself.

    This is when the server sends a Sampling request to the client asking
    for a claim investigation.

Apart from sending sampling request and receiving sampling response at
the server end, the client needs to define a sampling handler. *There may
be just one sampling handler for the entire MCP client*, so any branching
or routing logic has to be worked out internally between the MCP server
(sampling requester) and the client sampling handler.

## Code example

```clojure linenums="1" hl_lines="10-13 18-20 28"
--8<-- "apps/hello-mcp-clj/src/hello_mcp_clj/client/sampling.clj"
```

Sampling is supported at both var annotation level (var discovery) and
manual definition as we note above.
