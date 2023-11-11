#  TP 4 Inteligencia Artificial 🧪

Introducción
El objetivo para esta actividad es:
-    Elaborar e implementar la solución a través de la interpretación de imágenes, utilizando un proceso apropiado de transformación, para luego identificar y justificar la solución más conveniente.
________________________________________

## 🛠️ Consigna

A partir de la descripción realizada del problema y sus implicancias, se deben cumplir las siguientes actividades, de forma individual.

1.    Revisar la transformación de Hough para rectas y circunferencias. Resumir su formulación y características, brindando ejemplos.
2.    Desarrollar e implementar un prototipo destinado a la transformada de Hough de rectas en el contexto de un caso sencillo. Describir sus características, ventajas y limitaciones, como así también resumir las dificultades encontradas.
3.    Desarrollar e implementar un prototipo destinado a la transformada de Hough de circunferencias en el contexto de un caso sencillo. Describir sus características, ventajas y limitaciones, como así también resumir las dificultades encontradas.
4.    Hacer un balance de los tres enfoques tratados con la finalidad de dar respuesta al problema presentado y enumerar ventajas e inconvenientes de cada uno según su opinión. Finalmente hacer tu recomendación y justificarla.

Los conceptos referidos a la transformada de Hough son presentados en el módulo 4 de la materia

________________________________________

## 🛠️ Instrucciones de Uso:
1. Asegúrate de tener OpenCV configurado en tu entorno de desarrollo Java.
2. Reemplaza "path/to/image.jpg" con la ruta de tu imagen.
3. Ejecuta cada programa para detectar líneas o circunferencias.
4. Los resultados se guardarán como "detected_lines.jpg" y "detected_circles.jpg".

________________________________________

```
1. Transformada de Hough para Rectas y Circunferencias
Transformada de Hough para Rectas: La Transformada de Hough es una técnica de análisis de imagen para la detección de formas geométricas, siendo las rectas uno de los casos más comunes. La formulación se basa en que cada punto de una imagen puede pertenecer a infinitas rectas, y cada recta se puede representar como un punto en un espacio de parámetros (espacio de Hough). Para rectas, este espacio se define comúnmente por los parámetros r y θ, donde:
•	r es la distancia desde el origen al punto más cercano en la recta.
•	θ es el ángulo de inclinación de la recta.
Cada punto en la imagen contribuye a un voto en el espacio de Hough, y las localizaciones con un alto número de votos corresponden a rectas en la imagen.
Ejemplo para Rectas: En una imagen con dos puntos, P1 y P2, cada uno generará una curva sinusoidal en el espacio de Hough. La intersección de estas curvas indica el r y θ de la recta que pasa por ambos puntos.
Transformada de Hough para Circunferencias: Para detectar circunferencias, la Transformada de Hough se extiende a un espacio tridimensional de parámetros: el centro de la circunferencia (a,b) y su radio R. Para cada punto en el borde de una circunferencia potencial, se vota por todos los centros y radios que podrían pasar por ese punto.
Ejemplo para Circunferencias: Si un punto P pertenece a una circunferencia, se votará por todos los centros (a,b) que estén a una distancia R de P, formando un cono en el espacio de parámetros.
2. Prototipo para la Transformada de Hough de Rectas
Desarrollo e Implementación: Un prototipo simple puede ser implementado en Java utilizando la librería OpenCV. El proceso general sería:
•	Convertir la imagen a escala de grises.
•	Aplicar un detector de bordes (como Canny).
•	Utilizar la función HoughLines para obtener las líneas.
Características, Ventajas y Limitaciones:
•	Características: Detecta líneas rectas incluso si están parcialmente ocultas o interrumpidas.
•	Ventajas: Robusta frente a ruido y capaz de detectar líneas con solo una parte visible.
•	Limitaciones: No es eficiente con imágenes de alta resolución o con un gran número de líneas; puede requerir ajuste de parámetros.
Dificultades Encontradas:
•	Ajustar los parámetros de umbral para la detección de bordes y la acumulación de votos en el espacio de Hough.
•	La presencia de ruido puede generar falsos positivos.
3. Prototipo para la Transformada de Hough de Circunferencias
Desarrollo e Implementación: Al igual que con las rectas, se puede usar OpenCV y su función HoughCircles para implementar la detección de circunferencias.
Características, Ventajas y Limitaciones:
•	Características: Puede detectar circunferencias sin necesidad de que estén completas en la imagen.
•	Ventajas: Funciona bien con objetos redondos y puede diferenciar entre círculos de diferentes tamaños.
•	Limitaciones: Requiere más poder computacional que la transformada para rectas; es sensible a los parámetros de umbral.
Dificultades Encontradas:
•	Determinar el rango de radios a buscar puede ser complicado.
•	El ajuste de parámetros es crítico y puede ser difícil de generalizar.
4. Balance de los Enfoques y Recomendación
Balance:
•	La transformada de Hough para rectas es más simple y menos costosa computacionalmente.
•	La transformada para circunferencias es más compleja, pero permite detectar formas más específicas.
•	Ambas transformadas son robustas frente a defectos en las formas que buscan detectar.
Ventajas e Inconvenientes:
•	Rectas:
•	Ventajas: Simplicidad y rapidez.
•	Inconvenientes: Limitada a líneas rectas, puede ser ineficiente con muchas líneas.
•	Circunferencias:
•	Ventajas: Capacidad para detectar formas redondas de diferentes tamaños.
•	Inconvenientes: Mayor complejidad y coste computacional.
Recomendación: Para un caso sencillo y con recursos limitados, recomendaría comenzar con la transformada de Hough para rectas debido a su simplicidad y eficiencia. Si el objetivo es detectar formas redondas y hay suficientes recursos computacionales, la transformada para circunferencias sería más adecuada.
Justificación: La elección depende del contexto específico del problema. Si la precisión en la detección de formas redondas es crucial y justifica el mayor coste computacional, entonces la transformada para circunferencias es la mejor opción. En cambio, para una rápida inspección y análisis de líneas rectas, la transformada para rectas es suficiente y más eficiente.
La elección del modelo dependerá de los requisitos específicos del problema, los recursos disponibles y el nivel de precisión requerido.
```