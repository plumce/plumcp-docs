# PluMCP Server

As we saw in [Quickstart](../quickstart.md) the main entrypoint of
PluMCP Server is function `plumcp.core.api.mcp-server/run-server`,
which accepts several options.

Below are few common options (check source for exhaustive list):

- `:info` (**_required_**) is MCP server info, may be constructed
  using `plumcp.core.api.entity-support/make-info`
- `:instructions` (_optional_) is a text communicated by the server
  to the client
- `:transport` (_optional_) is either `:stdio` (default) or `:http`
- `:runtime` (_optional_) is derived from other args if unspecified
    - `:capabilities` (_optional_) is constructed from options below
        - `:primitives` (_optional_) is a map with keys
          `:prompts`, `:resources`, `:tools`, `:callbacks`
        - `:vars` (_optional_) is a vector of annotated var instances
        - `:ns` (_optional_, default: current namespace) is a vector
          of namespaces

!!! info "Server capabilities"

    A PluMCP server makes use of server capabilities to deliver its
    features. There are several ways to expose server capabilities.
    While `:primitives` is the low-level way to specify capabilities,
    `:vars` and `:ns` allow the use of annotated vars to discover
    capabilities.

    When you specify `{:ns [myapp.foo myapp.bar]}` it searches through
    all annotated vars in those namespaces to discover the primitives.
    Similarly, specifying `{:vars [#'myapp.foo/baz #'myapp.bar/quux]}`
    causes only those annotated vars to be scanned as primitives.

### Runing an STDIO server

```clojure
(plumcp.core.api.mcp-server/run-server
  {:info server-info
   :transport :stdio     ; optional
   :instructions "..."   ; optional
   :ns [app.foo app.bar] ; optional
   })
```

### Running Streamable HTTP server

```clojure
(plumcp.core.api.mcp-server/run-server
  {:info server-info
   :transport :http      ; implies Streamable HTTP server
   :instructions "..."   ; optional
   :ns [app.foo app.bar] ; optional
   })
```

## Potential Questions

_Adapted from:_ https://lnkd.in/p/ghprHMAA

#### How does the agent discover MCP servers and their capabilities?

- It does not "find" them. Servers come from config or an allowlisted registry.
- The initialize handshake has both sides declare capabilities.
- The `tools/list` result includes name, description and schema. That is what
  the LLM sees.
- Tool descriptions are prompt input. You should review and pin those.

#### How do you handle authentication and authorization between the agent and MCP servers?

- The MCP server acts as an OAuth 2.1 resource server.
- When an HTTP request without a valid token lands on the MCP server HTTP 401
  is returned with resource metadata, which leads the client to auth-code and
  [PKCE](https://www.mcpforge.tech/blog/oauth-pkce-mcp).
- The token is short-lived and audience-bound to that one server.
- The token is not used for passthrough. Downstream APIs get a token exchange.

#### How do you scope OAuth per capability, especially for sensitive actions?

- Design a tool for single scope, e.g. `payments.read` and `payments.transfer`
  are distinct scopes - tools using these scopes should serve scoped purpose.
- PluMCP checks the OAuth2 scope on every `tools/call`. When designing tools
  you may filter the `tools/list` by scope.
- Missing scope for a call returns HTTP 403 `insufficient_scope`, followed by
  step-up and human approval.
- Amount, environment and tenant limits may live in gateway policy, with an
  audit log per user and per agent for traceability.

