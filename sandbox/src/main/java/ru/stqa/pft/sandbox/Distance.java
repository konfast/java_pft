package ru.stqa.pft.sandbox;

public class Distance {
  public static void main(String[] args) {
    Point p1 = new Point (8.55, 4.32);
    Point p2 = new Point (45.91, 12.84);
    System.out.println ("Расстояние между двумя точками на двумерной плоскости равно: " + p1.distance(p2));
  }
  /*public static double distance(Point p1, Point p2) {
    return Math.sqrt (Math.pow((p1.x - p2.x), 2) + Math.pow((p1.y - p2.y), 2));
  }*/

}
