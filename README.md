# WeatherPrediction
Weather predictor (Java, Spring-boot, Maven).

Pronóstico (API REST)

En una galaxia lejana, existen tres civilizaciones. Vulcanos, Ferengis y Betasoides. Cada
civilización vive en paz en su respectivo planeta.
Dominan la predicción del clima mediante un complejo sistema informático.

Premisas:
● El planeta Ferengi se desplaza con una velocidad angular de 1 grados/día en sentido
horario. Su distancia con respecto al sol es de 500Km.
● El planeta Betasoide se desplaza con una velocidad angular de 3 grados/día en sentido
horario. Su distancia con respecto al sol es de 2000Km.
● El planeta Vulcano se desplaza con una velocidad angular de 5 grados/día en sentido
anti­horario, su distancia con respecto al sol es de 1000Km.
● Todas las órbitas son circulares.
Cuando los tres planetas están alineados entre sí y a su vez alineados con respecto al sol, el
sistema solar experimenta un período de sequía.

Cuando los tres planetas no están alineados, forman entre sí un triángulo. Es sabido que en el
momento en el que el sol se encuentra dentro del triángulo, el sistema solar experimenta un
período de lluvia, teniendo éste, un pico de intensidad cuando el perímetro del triángulo está en
su máximo.

Las condiciones óptimas de presión y temperatura se dan cuando los tres planetas están
alineados entre sí pero no están alineados con el sol

Realizar un programa informático para poder predecir en los próximos 10 años:
1. ¿Cuántos períodos de sequía habrá?
2. ¿Cuántos períodos de lluvia habrá y qué día será el pico máximo de lluvia?
3. ¿Cuántos períodos de condiciones óptimas de presión y temperatura habrá?
Bonus:
Para poder utilizar el sistema como un servicio a las otras civilizaciones, los Vulcanos requieren
tener una base de datos con las condiciones meteorológicas de todos los días y brindar una API
REST de consulta sobre las condiciones de un día en particular.
1) Generar un modelo de datos con las condiciones de todos los días hasta 10 años en adelante
utilizando un job para calcularlas.
2) Generar una API REST la cual devuelve en formato JSON la condición climática del día
consultado.
3) Hostear el modelo de datos y la API REST en un cloud computing libre (como APP Engine o
Cloudfoudry) y enviar la URL para consulta:
Ej: GET → http://….../clima?dia=566 → Respuesta: {“dia”:566, “clima”:”lluvia”}

A tener en cuenta



Se tomó como ciclo base o año, 360 días, momento en que los 3 planetas vuelven a su posición de inicio. (Grado 0).

Los días de picos de intensidad se dan cuando el perímetro del triángulo está en su máximo y contiene al sol. Y se repiten 4 veces por año que son los cuatro días de perímetro máximo. 



Iniciar el programa



Localmente solo hace falta darle ‘Run’ a la clase main para verificar los servicios. 

Se recomienda hacer un /reboot para borrar la base antes de comenzar.
Se da al usuario la opción de iniciar la base a través de /build-DB



Nube 

Service: http://weatherml.sa-east-1.elasticbeanstalk.com/

Base de datos: heroku



API services: 



Iniciar base de datos



http://weatherml.sa-east-1.elasticbeanstalk.com/build-DB



Consultar clima de un día en particular



http://weatherml.sa-east-1.elasticbeanstalk.com/clima?dia=566



Cantidad de períodos de sequía



http://weatherml.sa-east-1.elasticbeanstalk.com/periodos-sequia



Días de picos de intensidad



http://weatherml.sa-east-1.elasticbeanstalk.com/picos-intensidad



Cantidad de períodos de lluvia



http://weatherml.sa-east-1.elasticbeanstalk.com/periodos-lluvia



Cantidad de períodos de condiciones óptimas



http://weatherml.sa-east-1.elasticbeanstalk.com/condiciones-optimas



Borrar campos de la base de datos



http://weatherml.sa-east-1.elasticbeanstalk.com/reboot 



Tecnologías utilizadas



-Java

-Spring-boot

-Data base H2

-AWS cloud

-Heroku



Mejoras posibles a desarrollar:



Incrementar el coverage del código. Por cuestiones de plazo de entrega no se agregaron más tests. 



Nuevos services que permitan al usuario :

Buscar una cantidad de períodos de un clima en un año específico. 

Buscar una cantidad de períodos de un clima indicando el plazo deseado. Ejemplo: 20 ańos. 


