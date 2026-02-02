---
icon: material/message-outline
---

# MCP Prompts

Prompts are parameterized message templates meant to construct
LLM prompts at the MCP-Client end. MCP clients lookup prompts
from the MCP server and with user-consent, pass parameters and
end up with the complete prompt to be sent to the LLM.

!!! info "Why Prompts?"

    Imagine, you have an "AI assistant" app that responds to user input.
    You are not going to send the user input directly as a prompt to the
    LLM - you would rather extract the intent and other contextual
    metadata from the user input, then structure a prompt (based on a
    template) as per your use cases in order to fetch a response.

    Prompts are useful to model such templates. You can create an entire
    library of prompts for various use cases in your MCP Server.

Here is a simple Chain of Verification (CoVe) prompt example.

```clojure linenums="1" hl_lines="17-28"
--8<-- "apps/hello-mcp-clj/src/hello_mcp_clj/prompt.clj"
```

#### Prompt Var definition

As you can see in the highlighted code example above, var annotations
convey the prompt metadata:

- `:mcp-name` (_optional_) The MCP prompt name - same as function name
  if unspecified
- `:mcp-type` `:prompt` indicates that this is an MCP prompt
- The function docstring acts as the prompt description
- An MCP primitive var is always an arity-1 function. The argument is
  a map of specified, annotated keyword args. In the example above -
  `query` is a prompt argument with specified `:doc` (description) and
  `:type` (JSON type) annotations.
- The function is called when MCP `get-prompt` method is invoked. The
  function body is supposed to return a `get-prompt result`, which is
  done above by the `plumcp.core.api.entity-gen/make-get-prompt-result`
  function.

Prompts can range from simple, rudimentary to complex, few-shot
instances, depending upon the use case. Prompts are important feature of
MCP servers to build capable agentic AI applications.
