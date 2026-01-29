(defproject hello-mcp-clj "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "https://example.com/FIXME"
  :dependencies [[org.clojure/clojure "1.12.4"]
                 [io.github.plumce/plumcp.core-json-charred "0.1.0"]]
  :main ^:skip-aot hello-mcp-clj.core
  :target-path "target/%s"
  :profiles {:uberjar
             {:aot :all
              :jvm-opts ["-Dclojure.compiler.direct-linking=true"]}})
