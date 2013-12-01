(ns leiningen.new.vertx
  (:require [leiningen.new.templates :refer [renderer name-to-path ->files]]
            [leiningen.core.main :as main]))

(def render (renderer "vertx"))

(defn vertx
  "Create a new Vert.x project"
  [name]
  (let [data {:name name
              :sanitized (name-to-path name)}]
    (main/info "Generating fresh 'lein new' Vert.x project.")
    (->files data
             ["project.clj", (render "project.clj" data)]
             ["LICENSE", (render "LICENSE" data)]
             ["README.md", (render "README.md" data)]
             ["src/{{sanitized}}/core.clj" (render "src/skel/core.clj" data)])))
