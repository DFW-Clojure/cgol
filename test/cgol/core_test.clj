(ns cgol.core-test
  (:use clojure.test
        cgol.core))

(deftest generate-block
  (let [seed     [[0 0 0 0]
                  [0 1 1 0]
                  [0 1 1 0]
                  [0 0 0 0]]
        expected seed]
    (is (= expected (generate seed)))))

(deftest generate-alive-to-dead
  (let [expected [[0 0 0]
                  [0 0 0]
                  [0 0 0]]
        seed     [[0 0 0]
                  [0 1 0]
                  [0 0 0]]]
    (is (= expected (generate seed)))))

(deftest generate-blinker
  (let [period-one [[0 0 0 0 0]
                    [0 0 0 0 0]
                    [0 1 1 1 0]
                    [0 0 0 0 0]
                    [0 0 0 0 0]]
        period-two [[0 0 0 0 0]
                    [0 0 1 0 0]
                    [0 0 1 0 0]
                    [0 0 1 0 0]
                    [0 0 0 0 0]]]
    (is (= period-one (generate period-two)))
    (is (= period-two (generate period-one)))))

(deftest generate-toad
  (let [period-one [[0 0 0 0 0 0]
                    [0 0 0 1 0 0]
                    [0 1 0 0 1 0]
                    [0 1 0 0 1 0]
                    [0 0 1 0 0 0]
                    [0 0 0 0 0 0]]
        period-two [[0 0 0 0 0 0]
                    [0 0 0 0 0 0]
                    [0 0 1 1 1 0]
                    [0 1 1 1 0 0]
                    [0 0 0 0 0 0]
                    [0 0 0 0 0 0]]]
    (is (= period-one (generate period-two)))
    (is (= period-two (generate period-one)))))

(deftest generate-beacon
  (let [period-one [[0 0 0 0 0 0]
                    [0 1 1 0 0 0]
                    [0 1 0 0 0 0]
                    [0 0 0 0 1 0]
                    [0 0 0 1 1 0]
                    [0 0 0 0 0 0]]
        period-two [[0 0 0 0 0 0]
                    [0 1 1 0 0 0]
                    [0 1 1 0 0 0]
                    [0 0 0 1 1 0]
                    [0 0 0 1 1 0]
                    [0 0 0 0 0 0]]]
    (is (= period-one (generate period-two)))
    (is (= period-two (generate period-one)))))

(deftest generate-pulsar
  (let [period-one [[0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0]
                    [0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0]
                    [0 0 0 0 1 1 1 0 0 0 1 1 1 0 0 0 0]
                    [0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0]
                    [0 0 1 0 0 0 0 1 0 1 0 0 0 0 1 0 0]
                    [0 0 1 0 0 0 0 1 0 1 0 0 0 0 1 0 0]
                    [0 0 1 0 0 0 0 1 0 1 0 0 0 0 1 0 0]
                    [0 0 0 0 1 1 1 0 0 0 1 1 1 0 0 0 0]
                    [0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0]
                    [0 0 0 0 1 1 1 0 0 0 1 1 1 0 0 0 0]
                    [0 0 1 0 0 0 0 1 0 1 0 0 0 0 1 0 0]
                    [0 0 1 0 0 0 0 1 0 1 0 0 0 0 1 0 0]
                    [0 0 1 0 0 0 0 1 0 1 0 0 0 0 1 0 0]
                    [0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0]
                    [0 0 0 0 1 1 1 0 0 0 1 1 1 0 0 0 0]
                    [0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0]
                    [0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0]]
        period-two [[0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0]
                    [0 0 0 0 0 1 0 0 0 0 0 1 0 0 0 0 0]
                    [0 0 0 0 0 1 0 0 0 0 0 1 0 0 0 0 0]
                    [0 0 0 0 0 1 1 0 0 0 1 1 0 0 0 0 0]
                    [0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0]
                    [0 1 1 1 0 0 1 1 0 1 1 0 0 1 1 1 0]
                    [0 0 0 1 0 1 0 1 0 1 0 1 0 1 0 0 0]
                    [0 0 0 0 0 1 1 0 0 0 1 1 0 0 0 0 0]
                    [0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0]
                    [0 0 0 0 0 1 1 0 0 0 1 1 0 0 0 0 0]
                    [0 0 0 1 0 1 0 1 0 1 0 1 0 1 0 0 0]
                    [0 1 1 1 0 0 1 1 0 1 1 0 0 1 1 1 0]
                    [0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0]
                    [0 0 0 0 0 1 1 0 0 0 1 1 0 0 0 0 0]
                    [0 0 0 0 0 1 0 0 0 0 0 1 0 0 0 0 0]
                    [0 0 0 0 0 1 0 0 0 0 0 1 0 0 0 0 0]
                    [0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0]]
        period-iii [[0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0]
                    [0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0]
                    [0 0 0 0 1 1 0 0 0 0 0 1 1 0 0 0 0]
                    [0 0 0 0 0 1 1 0 0 0 1 1 0 0 0 0 0]
                    [0 0 1 0 0 1 0 1 0 1 0 1 0 0 1 0 0]
                    [0 0 1 1 1 0 1 1 0 1 1 0 1 1 1 0 0]
                    [0 0 0 1 0 1 0 1 0 1 0 1 0 1 0 0 0]
                    [0 0 0 0 1 1 1 0 0 0 1 1 1 0 0 0 0]
                    [0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0]
                    [0 0 0 0 1 1 1 0 0 0 1 1 1 0 0 0 0]
                    [0 0 0 1 0 1 0 1 0 1 0 1 0 1 0 0 0]
                    [0 0 1 1 1 0 1 1 0 1 1 0 1 1 1 0 0]
                    [0 0 1 0 0 1 0 1 0 1 0 1 0 0 1 0 0]
                    [0 0 0 0 0 1 1 0 0 0 1 1 0 0 0 0 0]
                    [0 0 0 0 1 1 0 0 0 0 0 1 1 0 0 0 0]
                    [0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0]
                    [0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0]]]
    (is (= period-two (generate period-one)))
    (is (= period-iii (generate period-two)))
    (is (= period-one (generate period-iii)))))

(deftest tick-under-population
  (is (= 0 (tick 1 [0 0 0 0 0 0 0 0])))
  (is (= 0 (tick 1 [1 0 0 0 0 0 0 0]))))

(deftest tick-survival
  (is (= 1 (tick 1 [1 1 0 0 0 0 0 0])))
  (is (= 1 (tick 1 [1 1 1 0 0 0 0 0]))))

(deftest tick-overcrowding
  (is (= 0 (tick 1 [1 1 1 1 0 0 0 0])))
  (is (= 0 (tick 1 [1 1 1 1 1 0 0 0])))
  (is (= 0 (tick 1 [1 1 1 1 1 1 0 0])))
  (is (= 0 (tick 1 [1 1 1 1 1 1 1 0])))
  (is (= 0 (tick 1 [1 1 1 1 1 1 1 1]))))

(deftest tick-reproduction
  (is (= 1 (tick 0 [1 1 1 0 0 0 0 0]))))

(deftest tick-dead-zone
  (is (= 0 (tick 0 [0 0 0 0 0 0 0 0])))
  (is (= 0 (tick 0 [1 0 0 0 0 0 0 0])))
  (is (= 0 (tick 0 [1 1 0 0 0 0 0 0])))
  (is (= 0 (tick 0 [1 1 1 1 0 0 0 0])))
  (is (= 0 (tick 0 [1 1 1 1 1 0 0 0])))
  (is (= 0 (tick 0 [1 1 1 1 1 1 0 0])))
  (is (= 0 (tick 0 [1 1 1 1 1 1 1 0])))
  (is (= 0 (tick 0 [1 1 1 1 1 1 1 1]))))

(deftest test-neighbors
  (is (= [0 0 0 0 0 0 0 0] (neighbors [[0 0 0] [0 1 0] [0 0 0]] 1 1)))
  (is (= [1 0 0 0 0 0 0 0] (neighbors [[1 0 0] [0 1 0] [0 0 0]] 1 1)))
  (is (= [0 1 0 0 0 0 0 0] (neighbors [[0 1 0] [0 1 0] [0 0 0]] 1 1)))
  (is (= [0 0 1 0 0 0 0 0] (neighbors [[0 0 1] [0 1 0] [0 0 0]] 1 1)))
  (is (= [0 0 0 1 0 0 0 0] (neighbors [[0 0 0] [1 1 0] [0 0 0]] 1 1)))
  (is (= [0 0 0 0 1 0 0 0] (neighbors [[0 0 0] [0 1 1] [0 0 0]] 1 1)))
  (is (= [0 0 0 0 0 1 0 0] (neighbors [[0 0 0] [0 1 0] [1 0 0]] 1 1)))
  (is (= [0 0 0 0 0 0 1 0] (neighbors [[0 0 0] [0 1 0] [0 1 0]] 1 1)))
  (is (= [0 0 0 0 0 0 0 1] (neighbors [[0 0 0] [0 1 0] [0 0 1]] 1 1))))
