(ns script
  (:require [clojure.tools.cli :as cli])
  (:gen-class))

(set! *warn-on-reflection* true)

(def cli-options
  "CLI option configuration; see https://github.com/clojure/tools.cli"
  ;; An option with a required argument
  [#_["-p" "--port PORT" "Port number"
      :default 80, :parse-fn #(Integer/parseInt %)
      :validate [#(< 0 % 0x10000) "Must be a number between 0 and 65536"]]
   ;; A non-idempotent option (:default is applied first)
   #_["-v" nil "Verbosity level"
      :id :verbosity, :default 0, :update-fn inc]
   ;; A boolean option defaulting to nil
   ["-h" "--help"]])

(defn -main [& args]
  (let [opts (cli/parse-opts args cli-options)]
    (when (get-in opts [:options :help])
      (println "Usage:")
      (println (:summary opts)))))
