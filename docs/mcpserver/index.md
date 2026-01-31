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
