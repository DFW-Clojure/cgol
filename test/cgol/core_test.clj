(ns cgol.core-test
  (:use clojure.test
        cgol.core))

(def block-board
  [:off :off :off :off
   :off :on  :on  :off
   :off :on  :on  :off
   :off :off :off :off])

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

(deftest print-board-test
  (testing "pretty print a flat board as a partitioned board"
    (is
     (= (with-out-str (print-board (make-board 3)))
        "(:off :off :off)\n(:off :off :off)\n(:off :off :off)\n"))))

(deftest get-in-board-test
  (testing "get the value at given x and y coordinate in a flat board"
    (are [ x y out]
     (= (get-in-board block-board x y)
        out)
     
     0 0 :off
     1 1 :on
     2 1 :on
     3 3 :off)))

(deftest neighbors-test
  (are [x y neighbors]
       (= (frequencies (get-neighbors block-board x y))
          neighbors)
       
       1 1 {:on 3 :off 5}
       0 0 {:on 1 :off 2}))