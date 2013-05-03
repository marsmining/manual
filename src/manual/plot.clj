(ns manual.plot
  "Draw a cartesian grid for basic plotting"
  (:require [quil.core :as q]))

(def scr-w 1000)
(def scr-h 1000)

;; we want our plot to always be -10 to +10
(def tick (quot scr-w 20))
(def tick-len (quot scr-w 50))

(def points (atom []))
(def lines (atom []))

(defn set-points [xs] (reset! points xs))

(defn setup []
  (q/smooth)
  (q/frame-rate 1)
  (q/background 200)
  (q/text-font (q/create-font "Helvetica" 20 true)))

(defn ticks
  [type [w h w2 h2] step z]
  (if (= type :h)
    (do
      (doseq [x (range (+ w2 step) w step)]
        (q/line [x (- h2 z)] [x (+ h2 z)]))
      (doseq [x (range (- w2 step) 0 (* step -1))]
        (q/line [x (- h2 z)] [x (+ h2 z)])))
    (do
      (doseq [y (range (+ h2 step) h step)]
        (q/line [(- w2 z) y] [(+ w2 z) y]))
      (doseq [y (range (- h2 step) 0 (* step -1))]
        (q/line [(- w2 z) y] [(+ w2 z) y])))))

(defn plot-point
  "Accepts cartesian"
  ([x y]
     (plot-point x y 10))
  ([x y w]
     (let [x' (* (+ x 10) tick)
           y' (* (- 10 y) tick)
           label (str x "," y)]
       (q/ellipse x' y' w w)
       (q/text label (+ x' w) (+ y' w)))))

(defn draw-plot []
  (let [w (q/width)
        h (q/height)
        w2 (quot w 2)
        h2 (quot h 2)]

    ;; x/y
    (q/line [w2 0] [w2 h])
    (q/line [0 h2] [w h2])

    (q/stroke-weight 1)

    ;; tick marks
    (ticks :h [w h w2 h2] tick tick-len)
    (ticks :v [w h w2 h2] tick tick-len)))

(defn draw []

  (q/background 200)
  (q/stroke 0)
  (q/stroke-weight 3)
  (q/fill 100)

  (draw-plot)

  (doseq [[x y] @points]
    (plot-point x y))
  
  )

(defn start []
  (q/defsketch graph
    :title "simple graph"
    :setup setup
    :draw draw
    :size [scr-w scr-h]))

(defn stop []
  (q/sketch-close graph))
