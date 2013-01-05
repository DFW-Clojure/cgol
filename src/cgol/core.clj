(ns cgol.core
  (:use [ clojure.math.numeric-tower 
         :only (sqrt exact-integer-sqrt)]))

(defn make-board
  "Create a new square vector board given the edge length"
  [n]
  (vec (repeat (* n n) :off)))

(defn partition-board
  "Take a flat vector board and partition it into a seq of seqs"
  [board]
  {:pre [(let [[n r] (exact-integer-sqrt (count board))]
            (zero? r))]}

  (let [n (sqrt (count board))]
    (partition n board)))

(defn print-board
  "Pretty print a board"
  [board]
  )