(ns inverse-captcha.part-two)

;; calc index
(defn newIndex [i v]
  (let [a (/ (count v) 2)]
    (if (>= (+ a i) (count v)) 
      (- (+ a i) (count v))   
      (+ a i)
    )  
  )
)

;; compare numbers
(defn amountToAdd [index v]
  (if (= (get v index) (get v (newIndex index v)))
    (get v index)
    0
  )
)
;; compare numbers
(defn equal [index v]
  (= (get v index) (get v (newIndex index v)))
)

(defn charToInt [c]
  (Character/digit c 10)
)

;; make int vector of string of digits
(defn intvector [s]
  (mapv charToInt (seq s))
)
(defn inverse-captcha [s]
  (def values (intvector s) )
  (dotimes [i (count values)]
    (def amount (amountToAdd i values))
    (if (not= amount 0) (println amount))
    )
)
   

(defn -main
  "I don't do a whole lot."
  [& args]
  (println args)
)
