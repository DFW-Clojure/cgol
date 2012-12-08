(ns cgol.core-test
  (:use clojure.test
        cgol.core))

(deftest block
  (let [seed     [[0 0 0 0]
                  [0 1 1 0]
                  [0 1 1 0]
                  [0 0 0 0]]
        expected seed]
    (is (= expected (generate seed)))))
