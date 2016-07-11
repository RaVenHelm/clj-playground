(ns playground.records-test
  (:require [clojure.test :refer :all]
            [playground.records :refer :all]))

(def test-str "1,2,3")

(deftest test-comma-split
  (testing "String with commas will be split into collection"
    (is (= '("1" "2" "3") (comma-split test-str)))))
