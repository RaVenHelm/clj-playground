(ns playground.files
  (:require [clojure.java.io :refer [writer]]))

(defn write-file
  [fname content]
  (with-open [w (writer fname :append true)]
    (.write w content)))
