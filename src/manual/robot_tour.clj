(ns manual.robot-tour
  "Find shortest tour visiting each point in plane"
  (:require [manual.plot :as plot]))

(def s0 [[ 0  9] [ 2  8] [ 5  6] [ 5  2]
         [ 4  0] [ 3 -2] [ 0 -5] [-3 -4]
         [-5 -1] [-7  2] [-5  5] [-4  7]])

(defn distance
  "Distance between two points"
  [a b]
  (let [[xa ya] a
        [xb yb] b
        xd (- xa xb)
        yd (- ya yb)]
    (Math/sqrt (+ (* xd xd) (* yd yd)))))

(defn nearest
  "Nearest neighbor first pass, return list of lines"
  [[p & ps]]
  (cons p (map #(nth ps (second %))
               (sort (map #(vector (distance p %) %2)
                          ps (range 0 (count ps)))))))

(let [[p & ps] s0]
  (sort
   (map #(vector (distance p %) %2)
        ps (range 0 (count ps)))))

(comment

  (plot/start)

  (plot/stop)

  (plot/set-points [])

  (plot/set-points s0)

  (plot/set-lines (nearest s0))

  (nearest s0)

  )
