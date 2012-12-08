(ns cgol.core)

(defn all-pos-int?
  [& args]
  (every?
   #(and (integer? %) (pos? %))
   args))

(defn board
  "Make a game board"
  [w h]
  {:pre [(all-pos-int? w h)]}
  (vec (repeat w
               (vec (repeat h nil)))))

(defn get-coord
  "Get the liveness value of the given coordinate"
  [x y]
  {:pre [(all-pos-int? x y)]}
  (get-in x y))

(defn set-coord
  "Set the liveness value of the given coordinate"
  [board x y liveness]
  {:pre [(all-pos-int? x y)]}
  (assoc-in board [x y] liveness))

(defn seed
  "A seq of x,y coords of live cells"
  [board & lives]
  (reduce
   (fn [current-board [x y]]
     (set-coord current-board x y :live))
   board
   lives))
