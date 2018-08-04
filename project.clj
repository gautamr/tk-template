(def tk-version "1.5.6")
(def ks-version "2.5.2")

(defproject lab/tk-template "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :pedantic? :abort
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/tools.cli "0.3.7"]
                 [org.clojure/tools.logging "0.4.1"]
                 [org.clojure/data.json "0.2.6"]
                 [yogthos/config "1.1.1"]

                 [org.slf4j/slf4j-api "1.7.25"]
                 [org.clojure/tools.reader "1.3.0"]
                 [commons-codec "1.11"]
                 [commons-fileupload "1.3.3"]
                 [commons-io "2.6"]
                 [joda-time "2.10"]
                 [clj-time "0.14.4"]
                 [cheshire "5.8.0"]
                 [com.fasterxml.jackson.dataformat/jackson-dataformat-cbor "2.9.6"]
                 [com.fasterxml.jackson.core/jackson-core "2.9.6"]
                 [com.fasterxml.jackson.dataformat/jackson-dataformat-smile "2.9.6"]
                 [ring/ring-core "1.6.3"]
                 [ring/ring-defaults "0.3.2"]
                 [ring/ring-codec "1.1.1"]
                 [ring/ring-headers "0.3.0"]
                 [ring/ring-ssl "0.3.0"]
                 [ring/ring-anti-forgery "1.3.0"]
                 [prismatic/schema "1.1.9"]
                 [puppetlabs/i18n "0.8.0"]
                 [puppetlabs/kitchensink ~ks-version]

                 [puppetlabs/comidi "0.3.2"]
                 [puppetlabs/trapperkeeper-metrics "1.1.0"]
                 [puppetlabs/trapperkeeper-comidi-metrics "0.1.2"]
                 [puppetlabs/trapperkeeper ~tk-version]
                 [puppetlabs/trapperkeeper-status "1.1.0"]
                 [puppetlabs/trapperkeeper-scheduler "0.1.0"]
                 [puppetlabs/trapperkeeper-webserver-jetty9 "2.2.0"]

                 [puppetlabs/kitchensink ~ks-version]]
  :plugins [[lein-pprint "1.1.2"]
            [lein-cloverage "1.0.11" :exclusions [org.clojure/clojure]]]
  :profiles {:local {:resource-paths ["config/local"]
                     :dependencies [[puppetlabs/trapperkeeper ~tk-version :classifier "test" :scope "test"]
                                    [puppetlabs/kitchensink ~ks-version :classifier "test" :scope "test"]
                                    [clj-http "3.9.1"]
                                    [org.clojure/tools.namespace "0.2.11"]
                                    [ring/ring-mock "0.3.2"]]}
             :dev   {:resource-paths ["config/dev"]}
             :qa    {:resource-paths ["config/qa"]}
             :uat   {:resource-paths ["config/uat"]}
             :prod  {:resource-paths ["config/prod"]}
             :uberjar {:aot :all}}
  :repl-options {:init-ns user}
  :aliases {"tk" ["trampoline" "run" "--config" "dev-resources/config.conf"]
            "example" ["run" "-m" "lab.tk-template-comidi-metrics-web-app"]
            "example-data" ["run" "-m" "lab.tk-template-traffic-generator"]}
  :main ^:skip-aot puppetlabs.trapperkeeper.main
  :target-path "target/%s")
