---
icon: material/tools
---

# MCP Tools (Server)

An MCP tool represents an action that a model may be allowed to invoke.
In the LLM context, MCP tools may be described as actions that the LLM
may know and choose to prescribe to achieve a certain goal.

!!! info "Tools are the MCP server workhorse"

    Tools are commonly the biggest use case for MCP servers. The tools
    encapsulate the interface to business systems and implementation
    that MCP clients can access.

    From an implementation perspective, tools are remote functions
    invoked over the MCP protocol. MCP clients specify the tool name
    and arguments to call the tool.

As you may have seen in [Quickstart](../quickstart.md) a tool is
composed of the tool metadata and a handler function. Let us see
another tool example:

```clojure linenums="1" hl_lines="16-25"
--8<-- "apps/hello-mcp-clj/src/hello_mcp_clj/tool.clj"
```

!!! abstract "Client call"

    See [Tools (Client)](../mcpclient/tools.md) for the client call.

#### Tool Var definition

As you can see in the highlighted code example above, var annotations
convey the tool metadata whereas the function itself produces the result:

- `:mcp-name` (_optional_) The MCP tool name - same as function name
  if unspecified
- `:mcp-type` `:tool` indicates that this is an MCP tool
- The function docstring acts as the tool description
- An MCP primitive var is always an arity-1 function. The argument is
  a map of specified, annotated keyword args. In the example above -
  `part-no` and `weeks` are tool arguments with specified `:name` (name,
  _optional_), `:doc` (description) and `:type` (JSON type) annotations.
  The `:default`, `:minimum` and `:maximum` hints are for UI hints.
- The function is called when MCP `call-tool` method is invoked. The
  function body is supposed to return a `call-tool result`, which is
  done above by the `plumcp.core.api.entity-gen/make-call-tool-result`
  function.

In practice, tools are very business specific. Since AI Agents are
associated with natural language the tool implementations often need
to incorporate search (e.g. similar text) along with their business
implementation.
