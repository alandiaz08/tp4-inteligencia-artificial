package org.example;

import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class HoughLinesDetector {

  static { System.loadLibrary(Core.NATIVE_LIBRARY_NAME); }

  public static void main(String[] args) {
    // Carga la imagen en escala de grises
    Mat src = Imgcodecs.imread("path/to/image.jpg", Imgcodecs.IMREAD_GRAYSCALE);
    if(src.empty()) {
      System.out.println("Error al cargar la imagen");
      return;
    }

    // Detecta los bordes en la imagen
    Mat edges = new Mat();
    Imgproc.Canny(src, edges, 50, 150);

    // Detecta las líneas en la imagen
    Mat lines = new Mat();
    Imgproc.HoughLines(edges, lines, 1, Math.PI / 180, 100);

    // Dibuja las líneas detectadas en la imagen
    Mat houghLines = new Mat();
    src.copyTo(houghLines);
    for (int i = 0; i < lines.rows(); i++) {
      double[] l = lines.get(i, 0);
      double rho = l[0], theta = l[1];
      double a = Math.cos(theta), b = Math.sin(theta);
      double x0 = a * rho, y0 = b * rho;
      Point start = new Point(Math.round(x0 + 1000 * (-b)), Math.round(y0 + 1000 * a));
      Point end = new Point(Math.round(x0 - 1000 * (-b)), Math.round(y0 - 1000 * a));
      Imgproc.line(houghLines, start, end, new Scalar(0, 0, 255), 2);
    }

    // Guarda la imagen con las líneas detectadas
    Imgcodecs.imwrite("detected_lines.jpg", houghLines);
  }
}
