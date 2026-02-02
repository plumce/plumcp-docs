---
icon: material/download-multiple
---

# Installation

Please install the following software packages
required for Clojure/ClojureScript.

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
