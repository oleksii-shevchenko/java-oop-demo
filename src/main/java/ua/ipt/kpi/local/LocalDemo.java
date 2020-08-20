package ua.ipt.kpi.local;

public class LocalDemo {
    public static void main(String[] args) {
        Geometry geometry = new Geometry();

        System.out.println(geometry.vectorLength(0, 1, 2));
        System.out.println(geometry.vectorLength(2.2, -3, 4));
    }
}


class Geometry {
    public double vectorLength(double x, double y, double metric) {
        class Point {
            private final double x;
            private final double y;

            public Point(double x, double y) {
                this.x = x;
                this.y = y;
            }

            public double length() {
                return Math.pow(Math.pow(x, metric) + Math.pow(y, metric), 1 / metric);
            }
        }

        return new Point(x, y).length();
    }
}