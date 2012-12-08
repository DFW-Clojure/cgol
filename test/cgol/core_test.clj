(ns cgol.core-test
  (:use clojure.test
        cgol.core))


(deftest test-block
  (let [seed [[nil nil nil nil]
              [nil true true nil]
              [nil true true nil]
              [nil nil nil nil]]
        expected seed]
    (is (= (generate seed) expected))))

(deftest test-oscillator
  (let [seed [[nil nil nil nil nil]
              [nil nil true nil nil]
              [nil nil true nil nil]
              [nil nil true nil nil]
              [nil nil nil nil nil]]
        expected [[nil nil nil nil nil]
                  [nil nil nil nil nil]
                  [nil true true true nil]
                  [nil nil nil nil nil]
                  [nil nil nil nil nil]]]
    #_(is (= (generate seed) expected)
     )))

(deftest test-single-cell-death
  (let [seed [[nil nil nil]
              [nil true nil]
              [nil nil nil]]
        expected [[nil nil nil]
                  [nil nil nil]
                  [nil nil nil]]]
    (is (= (generate seed) expected))))
