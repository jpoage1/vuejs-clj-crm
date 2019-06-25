(defproject clj-crm "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [http-kit "2.3.0"]
                 [ring "1.7.1"]
                 [ring/ring-core "1.7.1"]
                 [ring/ring-devel "1.7.1"]
                 [ring/ring-jetty-adapter "1.7.1"]
                 [compojure "1.6.1"]
                 [org.clojure/data.json "0.2.6"]
                 [ring/ring-json "0.4.0"]
                 [amalloy/ring-gzip-middleware "0.1.3"]
                 [org.clojure/java.jdbc "0.6.1"]
                 [org.postgresql/postgresql "42.1.4"]]
  :source-paths ["clj-src"]
  :main ^:skip-aot clj-crm.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
