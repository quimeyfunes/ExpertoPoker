(ns fallas)

(println "Cantidad de jugadores? (1 a 6)")
(def jugadores (read-line))

(println "Monto de la mesa?")
(def monto (read-line))

(println "Apuesta?")
(def apuesta (read-line))

(println "Ingrese numero de mano")
(println "1. Carta")
(println "2. Par")
(println "3. Par Doble")
(println "4. Trio")
(println "5. Escalera")
(println "6. Color")
(println "7. Full")
(println "8. Poker")
(println "9. Escalera Real")
(def mano (read-line))


(defn jugada [jugadores monto apuesta mano]
  (if (= jugadores "5")
    (println "5 jugadores")
    (println "no 5 jugadores")
  )
)

(jugada jugadores monto apuesta mano)
