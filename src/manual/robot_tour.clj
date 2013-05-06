(ns manual.robot-tour
  "Find shortest tour visiting each point in plane"
  (:require [manual.plot :as plot]))

(defn distance
  "Distance between two points"
  [a b]
  (let [[xa ya] a
        [xb yb] b
        xd (- xa xb)
        yd (- ya yb)]
    (Math/sqrt (+ (* xd xd) (* yd yd)))))

(defn nearest-neighbors
  "Given a point, and list of points, find nearest neighbors"
  [p ps]
  (sort
   (map #(vector (distance p %) %2)
        ps (range 0 (count ps)))))

(defn robot-tour
  "Create list of points, representing best path"
  [[p & ps]]
  (when (seq ps)
    (let [[_ idx] (first (nearest-neighbors p ps))
          point (nth ps idx)]
      (conj (robot-tour ps) point))))

;; sample data
(def s0 [[ 0  9] [ 2  8] [ 5  6] [ 5  2]
         [ 4  0] [ 3 -2] [ 0 -5] [-3 -4]
         [-5 -1] [-7  2] [-5  5] [-4  7]])

(comment

  (plot/start)

  (plot/stop)

  (plot/set-points [])

  (plot/set-points s0)

  (plot/set-lines [])

  (plot/set-lines (conj (robot-tour s0) (first s0)))

  (robot-tour s0)

  )

