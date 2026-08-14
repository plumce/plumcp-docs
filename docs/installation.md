---
icon: material/download-multiple
---

# Prerequisite - Installation

Install the following software packages required for Clojure/ClojureScript.

This documentation uses [Leiningen](https://leiningen.org)
and [shadow-cljs](https://github.com/thheller/shadow-cljs) for
examples - you may choose any build tool that fits your purpose.

## For Development

=== "Clojure"
    - [Java 21 or higher](https://adoptium.net/temurin/releases/) (OpenJDK derived)
    - [Leiningen](https://leiningen.org) (to follow this documentation)
=== "Clojure on GraalVM"
    - GraalVM (either [Oracle](https://www.graalvm.org/downloads/) or [Community](https://github.com/graalvm/graalvm-ce-builds/releases)) - if your project is not suited for
      GraalVM, consider alternatives e.g. [jbundle](https://avelino.run/projects/jbundle/)
    - [Leiningen](https://leiningen.org) (to follow this documentation)
=== "ClojureScript"
    - [Java 21 or higher](https://adoptium.net/temurin/releases/) (OpenJDK derived, for development only)
    - [Node.js 21 or higher](https://nodejs.org/en/download) (LTS preferable - or at your option, Bun.js)

## For Deployment

=== "Clojure"
    - [Java 21 or higher](https://adoptium.net/temurin/releases/) (OpenJDK derived)
=== "Clojure on GraalVM"
    - None, if you have a native binary
=== "ClojureScript"
    - [Node.js 21 or higher](https://nodejs.org/en/download) (LTS preferable - or at your option, Bun.js)

## Coordinates

Use PluMCP (e.g. `plumcp.core` module) coordinates as follows:

- Leiningen/Shadow-CLJS: `[io.github.plumce/plumcp.core "<version>"]`
- deps.edn: `io.github.plumce/plumcp.core {:mvn/version "<version>"}`

As you see `io.github.plumce` is the common Group ID for all modules.

Find all modules and versions here:
[PluMCP on Clojars](https://clojars.org/search?q=plumcp.core)

| Module name               | Required? | Type  | Artifact ID                 |
|---------------------------|-----------|-------|-----------------------------|
| plumcp.core               | Required  | Core  | `plumcp.core`               |
| plumcp.core-dev           | Optional  | Addon | `plumcp.core-dev`           |
| plumcp.core-auth          | Optional  | Addon | `plumcp.core-auth`          |
| plumcp.core-json-charred  | Either    | JSON  | `plumcp.core-json-charred`  |
| plumcp.core-json-cheshire | Either    | JSON  | `plumcp.core-json-cheshire` |
| plumcp.core-json-datajson | Either    | JSON  | `plumcp.core-json-datajson` |
| plumcp.core-json-jsonista | Either    | JSON  | `plumcp.core-json-jsonista` |

At a minimum, you need `plumcp.core` and any one of the JSON modules
listed above. See the [Dependencies page](dependencies.md) to learn
about module inter-dependency.
