(defproject hello-mcp-clj "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "https://example.com/FIXME"
  :dependencies [[org.clojure/clojure "1.12.4"]
                 [io.github.plumce/plumcp.core-json-charred "0.1.0-SNAPSHOT"]
                 [com.github.clj-easy/graal-build-time "1.0.5"]]
  :main ^:skip-aot hello-mcp-clj.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all
                       :jvm-opts ["-Dclojure.compiler.direct-linking=true"]}
             :dev {:plugins [[lein-shell "0.5.0"]]}}
  :aliases
  {"native"
   ["shell"
    "native-image"
    "-Ob"
    "-H:+TraceNativeToolUsage"
    "-H:+AllowIncompleteClasspath"
    "--verbose"
    "--no-fallback"
    "--report-unsupported-elements-at-runtime"
    ;; add here the namespaces of the library to test separated by commas
    "--features=clj_easy.graal_build_time.InitClojureClasses"
    "-jar"
    "./target/uberjar/${:uberjar-name:-${:name}-${:version}-standalone.jar}"
    "-H:Name=./target/${:name}"]

   "run-native" ["shell" "./target/${:name}"]})
