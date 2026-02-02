---
icon: material/file-document-outline
---

# MCP Resources

An MCP Resource is a URI-addressable, read-only, text or binary payload
of data at the MCP server that a model is allowed to see. The resource
content is tagged with a MIME-type to describe the content type.

Internally, a resource is a data abstraction backed by static or dynamic
content in storage and discovery. Examples of resources are user-profile
data, a database schema, business configuration, business knowledge
documents etc.

!!! info "Resource vs Resource template - Difference only in exposure"

    Resources may be exposed as MCP server capability in either of two ways:

    - Resource: has fixed URI, e.g. `worksheet://acct/2026/1351`
    - Resource Template: has URI template, e.g. `workorder://shopfloor/2026/{id}`

    The MCP `read-resource` call contains a full URI that automatically
    maps to either a matching resource or a matching resource template.

Here are resource and resource template examples:

```clojure linenums="1" hl_lines="12-19 30-38"
--8<-- "apps/hello-mcp-clj/src/hello_mcp_clj/resource.clj"
```

#### Resource Var definition

As you can see in the highlighted code example above, var annotations
convey the resource metadata:

- `:mcp-name` (_optional_) The MCP resource name - same as function name
  if unspecified
- `:mcp-type` `:resource` indicates that this is an MCP resource
- `:mcp-type` `:resource-template` indicates this is an MCP resource
  template
- The function docstring acts as the resource description
- An MCP primitive var is always an arity-1 function. The argument is
  a map of specified, annotated keyword args. In the example above -
  `uri` (and `params` for resource templates) are resource arguments
  with specified `:doc` (URI or URI-template for `uri`, docstring for
  `params`) annotations.
- The function is called when MCP `read-resource` method is invoked. The
  function body is supposed to return a `read-resource result`, which is
  done above by the `plumcp.core.api.entity-support/make-text-resource-result`
  function.

Resources can be put to good use by offloading business and contextual
knowledge base, and other data as resources. This helps make AI Agents
lightweight where they depend on MCP servers to do this heavy lifting.
