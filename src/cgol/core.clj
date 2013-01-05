(ns cgol.core
  (:use [ clojure.math.numeric-tower 
         :only (sqrt exact-integer-sqrt)]))

(defn make-board
  "Create a new square vector board given the edge length"
  [n]
  (vec (repeat (* n n) :off)))

(defn get-n [board]
  (sqrt (count board)))

(defn partition-board
  "Take a flat vector board and partition it into a seq of seqs"
  [board]
  {:pre [(let [[n r] (exact-integer-sqrt (count board))]
            (zero? r))]}

  (let [n (get-n board)]
    (partition n board)))

(defn print-board
  "Pretty print a flat board"
  [board]
  (doseq [r (partition-board board)]
    (println r)))

(defn- coords->flat
  [n x y]
  (+ x (* n y)))

(defn get-in-board
  "Get the board value for a given board, x, and y coordinate"
  [board x y]
  (let [n (get-n board)
        i (coords->flat n x y)]
    (board i)))

(defn set-in-board
  [board x y value]
  (let [n (get-n board)
        i (coords->flat n x y)]
  (assoc board i value)))

(defn get-neighbors
  [board x y]
  (let [n          (get-n board)
        neighbor-d (for [dx (range -1 2) dy (range -1 2) 
                         :when (not (every? zero? [dx dy]))] 
                     [dx dy])
        all-coords (map (fn [[dx dy]] [(+ x dx) (+ y dy)])
                             neighbor-d)
        neighbors  (filter (fn [[x y]] (and (<= 0 x (dec n))
                                            (<= 0 y (dec n))))
                           all-coords)]
    (map (fn [[x y]] (get-in-board board x y)) neighbors)))
  