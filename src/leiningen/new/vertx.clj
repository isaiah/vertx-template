(ns leiningen.new.vertx-template
  (:require [leiningen.new.templates :refer [renderer name-to-path ->files]]
            [leiningen.core.main :as main]))

(def render (renderer "vertx-template"))

(defn vertx
  "Create a new Vert.x project"
  [name]
  (let [data {:name name
              :sanitized (name-to-path name)}]
    (main/info "Generating fresh 'lein new' vertx-template project.")
    (->files data
             ["project.clj", (render "project.clj" data)]
             ["src/{{sanitized}}/core.clj" (render "core.clj" data)])))
