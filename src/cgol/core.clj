(ns cgol.core)

(defn tick [cell neighbors]
  (let [live-neighbors (apply + neighbors)]
    (case live-neighbors
      2 cell
      3 1
      0)))

(defn neighbors [board x y]
  [(nth (nth board (dec x) []) (dec y) 0)
   (nth (nth board (dec x) []) y 0)
   (nth (nth board (dec x) []) (inc y) 0)
   (nth (nth board x []) (dec y) 0)
   (nth (nth board x []) (inc y) 0)
   (nth (nth board (inc x) []) (dec y) 0)
   (nth (nth board (inc x) []) y 0)
   (nth (nth board (inc x) []) (inc y) 0)])

(defn generate [seed]
  (map-indexed
    (fn [row-index row]
      (map-indexed
        (fn [column-index cell]
          (tick cell (neighbors seed row-index column-index)))
      row))
    seed))
