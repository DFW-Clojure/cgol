(ns cgol.core-test
  (:use clojure.test
        cgol.core))

(deftest board-test
  (testing "Test board generation."
    (are [w h out]
         (= (board w h) out)
          1  2  [[nil nil]]
          2  1  [[nil] [nil]])
    (is (thrown? AssertionError (board "string" 1)))
    (is (thrown? AssertionError (board -1 -1)))))
