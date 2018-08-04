(ns lab.tk-template-core-test
  (:require [clojure.test :refer :all]
            [lab.tk-template-core :refer :all]))

(deftest hello-test
  (testing "says hello to caller"
    (is (= "Hello, foo!" (hello "foo")))))
