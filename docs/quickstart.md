---
icon: material/run
---

# Quickstart

This page will walk you through creating your first PluMCP server.

## Prerequisites

Make sure you have
[installed the required software](installation.md).

## 1. Create the MCP server app

Run the following commands in a terminal as follows:

=== "Clojure"
    ```shell
    lein new app hello-mcp-clj
    cd hello-mcp-clj
    ```
=== "Clojure on GraalVM"
    ```shell
    lein new app hello-mcp-clj
    cd hello-mcp-clj
    ```
=== "ClojureScript"
    With Node.js:
    ```shell
    npx create-cljs-project hello-mcp-cljs
    cd hello-mcp-cljs
    ```
    With Bun.js:
    ```shell
    bunx create-cljs-project hello-mcp-cljs
    cd hello-mcp-cljs
    ```

## 2. Add/edit the dependencies

Edit the files as highlighted below:

=== "Clojure"
    ```clojure title="project.clj" linenums="1" hl_lines="4-5"
    --8<-- "apps/hello-mcp-clj/project.clj"
    ```
=== "Clojure on GraalVM"
    ```clojure title="project.clj" linenums="1" hl_lines="4-6 11 12-28"
    --8<-- "apps/hello-mcp-clj/project-graal.clj"
    ```
=== "ClojureScript"
    ```edn title="shadow-cljs.edn" linenums="1" hl_lines="8 11-13"
    --8<-- "apps/hello-mcp-cljs/shadow-cljs.edn"
    ```

## 3. Edit the sources

Add or edit the source files to add an MCP tool as follows:

=== "Clojure"
    ```clojure title="src/hello_mcp_clj/core.clj"  linenums="1" hl_lines="2-3 6 8-12 16"
    --8<-- "apps/hello-mcp-clj/src/hello_mcp_clj/core.clj"
    ```
=== "Clojure on GraalVM"
    ```clojure title="src/hello_mcp_clj/core.clj"  linenums="1" hl_lines="2-3 6 8-12 16"
    --8<-- "apps/hello-mcp-clj/src/hello_mcp_clj/core.clj"
    ```
=== "ClojureScript"
    Create any missing/required directory:
    ```shell
    mkdir -p src/main/hello_mcp_cljs
    ```
    Then create this file as follows:
    ```clojure title="src/main/hello_mcp_cljs/core.cljs" linenums="1" hl_lines="1-16"
    --8<-- "apps/hello-mcp-cljs/src/main/hello_mcp_cljs/core.cljs"
    ```

## 4. Compile/Run the MCP server

=== "Clojure"
    ```shell
    lein run
    ```
=== "Clojure on GraalVM"
    ```shell
    lein uberjar
    lein native
    lein run-native  # or ./target/hello-mcp-clj
    ```
=== "ClojureScript"
    Using Node.js:
    ```shell
    npx shadow-cljs compile :app
    node out/node-server.js
    ```
    Using Bun.js:
    ```shell
    bunx shadow-cljs compile :app
    bun out/node-server.js
    ```
When the MCP server is up and running, you may connect using
a suitable MCP client.
