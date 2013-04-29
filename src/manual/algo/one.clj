(ns manual.algo.one
  "Tour problem"
  (:require [quil.core :refer :all]))

(sketch-close graph)

(defn setup []
  (smooth)
  (frame-rate 1)
  (background 200))

(defn ticks
  [type [w h w2 h2] step z]
  (if (= type :h)
    (do
      (doseq [x (range (+ w2 step) w step)]
        (line [x (- h2 z)] [x (+ h2 z)]))
      (doseq [x (range (- w2 step) 0 (* step -1))]
        (line [x (- h2 z)] [x (+ h2 z)])))
    (do
      (doseq [y (range (+ h2 step) h step)]
        (line [(- w2 z) y] [(+ w2 z) y]))
      (doseq [y (range (- h2 step) 0 (* step -1))]
        (line [(- w2 z) y] [(+ w2 z) y])))))

(defn draw-plot
  []
  (let [w (width)
        h (height)
        w2 (quot w 2)
        h2 (quot h 2)]

    ;; x/y
    (line [w2 0] [w2 h])
    (line [0 h2] [w h2])

    (stroke-weight 1)

    ;; tick marks
    (ticks :h [w h w2 h2] 50 20)
    (ticks :v [w h w2 h2] 50 20)

    ))

(defn draw []

  (stroke 0)
  (stroke-weight 3)

  (draw-plot)

  )

(defsketch graph
  :title "simple graph"
  :setup setup
  :draw draw
  :size [969 600])

(comment

  (sketch-close graph)

  (show-cats)

  (show-fns 3)

  )
