(ns cgol.core-test
  (:use clojure.test
        cgol.core))

(deftest make-board-test
  (testing "board creation"
    (is 
     (= (make-board 2)
        [:off :off :off :off]))

    (are [n final-count]
     (= (count (make-board n))
        final-count)
     
     1 1
     2 4
     3 9
     4 16)))

(deftest partition-board-test
  (testing "transform flat board into a vector of vectors"
    (is
     (= (partition-board (make-board 2))
        [[:off :off] [:off :off]]))
    (is (thrown? AssertionError (partition-board [:off :off :off])))))