---
icon: material/chat-processing-outline
---

# MCP Elicitation

Elicitation is a way for an MCP server to request required information
from the user in order to continue.

!!! abstract "Elicitation Example"

    Let's say you are using a travel AI agent, requesting it to book a
    flight to Mumbai next Tuesday morning before 9am. The agent may know
    a lot about you, e.g. employer travel policy, your preferred airline,
    frequent flyer number etc, but it does not know which Mumbai airport.

    The MCP server would need to ask you which airport do you prefer. It
    needs to be translated into a UI popup asking to choose the airport:
    Mumbai (BOM) or Navi Mumbai (NMI). When you choose an option it gets
    communicated to the server, booking continues. This is Elicitation.

Note that there may be only one Elicitation handler per MCP client. So,
any branching or routing across request types needs to be handled by the
elicitation handler.

## Code example

```clojure linenums="1" hl_lines="8-14 22"
--8<-- "apps/hello-mcp-clj/src/hello_mcp_clj/client/elicitation.clj"
```
