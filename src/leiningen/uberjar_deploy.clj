(ns leiningen.uberjar-deploy
  (:require
    [leiningen.core.main :as main :refer [info]]
    [leiningen.deploy :as deploy :refer [deploy]]
    [leiningen.jar :as jar :refer [get-jar-filename]]
    [leiningen.pom :as pom :refer [snapshot?]]))

(defn uberjar-deploy
  "Deploys an existing uberjar with lein deploy"
  [project & args]
  (main/info "Preparing to deploy uberjar")
  (let [repository (if (pom/snapshot? project) "snapshots" "releases")
        group (:group project)
        name (:name project)
        identifier (format "%s/%s" group name)
        version (:version project)
        file (or (:jar-filename project) (jar/get-jar-filename project :standalone))
        pom (or (:pom project) "pom.xml")]
    (main/info "Running: lein deploy" repository identifier version file pom)
    (deploy/deploy project repository identifier version file pom)))
