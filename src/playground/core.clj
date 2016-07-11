(ns playground.core
  (:gen-class)
  (:require [clojure.pprint :as ppt :refer [pprint]]))

(defn my-xf [n]
  (comp
   (filter number?)
   (filter integer?)
   (filter pos?)
   (partition-all n)))

(defn init-app [& args]
  (atom {:version "0.1.0" :data [1 2 -10]}))

(def app-state (init-app))

(defn manip-1
  "Simple manipulation of a value from update"
  [_]
  (vec (filter even? (range 11))))

(defn f1 [state]
  (swap! state update :data manip-1))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (-> app-state
      f1)
  @app-state)

