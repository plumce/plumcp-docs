# PluMCP

![Language](https://img.shields.io/badge/Language-Clojure/CojureScript-8CC6B8)
![Maturity](https://img.shields.io/badge/Maturity-Alpha-orange)
[![Ask DeepWiki (useful but watch  for hallucinations)](https://deepwiki.com/badge.svg)](https://deepwiki.com/plumce/plumcp)

**[Model Context Protocol (MCP)](https://modelcontextprotocol.io/) SDK
for Java and JavaScript runtimes. Build MCP clients and servers using
[Clojure](https://clojure.org)/[ClojureScript](https://clojurescript.org).**

PluMCP is a low-dependency Clojure/ClojureScript library for making MCP
clients and servers. Connect AI Agents with your business (data, process
and software) using MCP and idiomatic Clojure.

??? info inline end "Supported platforms"

    <!-- Logos obtained from https://www.svgrepo.com -->
    <img src="assets/img/java.svg" width="50" title="Java (21 or higher)">
    <img src="assets/img/GraalVM.png" width="50" title="GraalVM (25 or higher)">
    <img src="assets/img/node-js.svg" width="50" title="Node.js (21 or higher)">
    <img src="assets/img/bun-js.svg" width="50" title="Bun.js (1.3.5 or higher)">
    <img src="assets/img/javascript.svg" width="50" title="JavaScript (ES6 or higher)">

[<img src="assets/img/clojure2.svg" width="50" title="Clojure (runs on Java)">](https://clojure.org)
[<img src="assets/img/cljs-logo-60b.png" width="50" title="ClojureScript (runs on JavaScript)">](https://clojurescript.org)
[<img src="assets/img/mcp-cropped.png" width="50" title="Model Context Protocol">](https://modelcontextprotocol.io)

## Why consider PluMCP?

- _Complete:_ Enjoy almost all non-deprecated MCP features and transports
- _Reach:_ Clojure/ClojureScript reaches Java/JavaScript eco-systems
- _Ergonomic:_ User-friendly API, automatic error-checking
- _Light:_ Low dependency, Bring your own dependency
- _Flexible:_ Composable design with configurable/overridable defaults
- _Secure:_ OAuth 2.1 integrated with Streamable HTTP transport

## Who is using PluMCP?

[<img src="assets/img/using-eca-logo-round.png" width="50" title="Editor Code Assistant">](https://eca.dev/)
[<img src="assets/img/using-nubank-logo-round.png" width="50" title="Nubank">](https://nubank.com.br/)

Are you using PluMCP? [TELL-US!](https://clojurians.slack.com/archives/plumcp)

## Status ![MCP SDK](https://img.shields.io/badge/Maturity-Alpha-orange)

- _Protocol version:_ 2025-06-18, 2025-03-26 (TODO: 2025-11-25)
- _Protocol implementation:_ Asynchronous, Full-duplex, Concurrent
- _Features:_ All non-deprecated client/server features supported
- _Transports:_ STDIO, Streamable HTTP (optionally with OAuth 2.1)

### Transports

| Platform                         | STDIO | Streamable HTTP | Streamable HTTP+OAuth 2.1 |
| -------------------------------- | ----- | --------------- | ------------------------- |
| Clojure/JVM MCP server           | Yes   | Yes             | Yes                       |
| Clojure/JVM MCP client           | Yes   | Yes             | Yes                       |
| ClojureScript/NodeJS MCP server  | Yes   | Yes             | Yes                       |
| ClojureScript/NodeJS MCP client  | Yes   | Yes             | Yes                       |
| ClojureScript/Browser MCP client | --    | Yes             | With customization only   |

# License

Copyright © 2025-2026 Shantanu Kumar

This program and the accompanying materials are made available under the
terms of the Eclipse Public License 1.0 which is available at
https://www.eclipse.org/legal/epl/epl-v10.html.
