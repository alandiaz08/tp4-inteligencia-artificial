package org.example;

import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class HoughCirclesDetector {

  static { System.loadLibrary(Core.NATIVE_LIBRARY_NAME); }

  public static void main(String[] args) {
    // Carga la imagen en escala de grises
    Mat src = Imgcodecs.imread("path/to/image.jpg", Imgcodecs.IMREAD_GRAYSCALE);
    if(src.empty()) {
      System.out.println("Error al cargar la imagen");
      return;
    }

    // Preprocesa la imagen para la detección de círculos
    Mat gray = new Mat();
    Imgproc.medianBlur(src, gray, 5);

    // Detecta los círculos en la imagen
    Mat circles = new Mat();
    Imgproc.HoughCircles(gray, circles, Imgproc.HOUGH_GRADIENT, 1.0,
            (double)gray.rows()/16, // Ajusta para detectar círculos a diferentes distancias
            100.0, 30.0, 1, 30); // Ajusta los últimos dos parámetros para detectar círculos más grandes

    // Dibuja los círculos detectados en la imagen
    Mat houghCircles = new Mat();
    src.copyTo(houghCircles);
    for (int x = 0; x < circles.cols(); x++) {
      double[] c = circles.get(0, x);
      Point center = new Point(Math.round(c[0]), Math.round(c[1]));
      // Centro del círculo
      Imgproc.circle(houghCircles, center, 1, new Scalar(0,100,100), 3, 8, 0 );
      // Contorno del círculo
      int radius = (int) Math.round(c[2]);
      Imgproc.circle(houghCircles, center, radius, new Scalar(255,0,255), 3, 8, 0 );
    }

    // Guarda la imagen con los círculos detectados
    Imgcodecs.imwrite("detected_circles.jpg", houghCircles);
  }
}

