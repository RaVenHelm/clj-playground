;; Testing record types
(ns playground.records
  (:require [clojure.string :as cstr]))

(defn comma-split
  "Split a string by comma"
  [string]
  (cstr/split string #","))

(defprotocol Talker (speak [this] "Method for speaking"))

(defprotocol ITransactionalRecord
  (transact
   [this [name age]]
   "Create a transaction and move the data into the reference"))

(defrecord Person [name age]
    Talker
    (speak [this] (str "My name is " (:name this))))

(defrecord TransctionalPerson [person]
  ITransactionalRecord
  (transact
   [this [name age]]
   (dosync
     (ref-set :person (Person. name age)))))

(def p (Person. "John Smith" 35))
(def p-ref (ref p))
(def p-transact (TransctionalPerson. p-ref))
p-ref
