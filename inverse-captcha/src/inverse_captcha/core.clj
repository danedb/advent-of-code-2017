(ns inverse-captcha.core)


(defn get-first [list]
  (read-string (get list 0))
  )  
  
(defn regexsum [list]
  (re-seq #"(\d)(?=\1)" list)
  )
    
(defn fixstring [s]
  (apply str (concat s (subs s 0 1)))
  )
        
(defn inverse-captcha [s]
  (reduce + (mapv get-first (regexsum (fixstring s))))
)
        
(defn -main
  "I don't do a whole lot."
  [& args]
  (println (inverse-captcha args))
)
