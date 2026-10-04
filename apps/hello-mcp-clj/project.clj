(defproject hello-mcp-clj "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "https://example.com/FIXME"
  :dependencies [[org.clojure/clojure "1.12.6"]
                 [io.github.plumce/plumcp.core-json-charred "0.3.0"]]
  :main ^:skip-aot hello-mcp-clj.core
  :target-path "target/%s"
  :plugins [[cider/cider-nrepl "0.62.2"]]
  :profiles {:uberjar
             {:aot :all
              :jvm-opts ["-Dclojure.compiler.direct-linking=true"]}})
