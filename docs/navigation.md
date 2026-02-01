# Code Navigation

The PluMCP codebase is organized under various namespaces. Most of the
public API is segregated under `plumcp.core.api.*` as listed below:

| Namespace                      | Description                  |
|--------------------------------|------------------------------|
|`plumcp.core.api.entity-gen`    | Generate MCP entities        |
|`plumcp.core.api.entity-support`| MCP entities Convenience fns |
|`plumcp.core.api.mcp-client`    | Running MCP client           |
|`plumcp.core.api.mcp-server`    | Running MCP server           |

The namespaces other than the public API are subject to change between
releases.

## Developing MCP apps in a Code editor

When developing MCP apps, it may be helpful to use an editor that
lets you explore and navigate the dependency (PluMCP) source code.
REPL-driven development is not necessary, but the ability to inspect
and navigate the dependency namespaces may be useful.

If you are new to Clojure, consider one of the following Clojure-LSP
enabled editor options as per your choice:

- Visual Studio Code (or VSCodium) wth Calva
- IntelliJ IDEA with Clojure-LSP (or Cursive)
- Emacs with LSP-mode (and optionally CIDER)
- Neovim with Conjure

Configuring an editor for your workflow is beyond the scope of this
document. Please explore the editor options as appropriate.
