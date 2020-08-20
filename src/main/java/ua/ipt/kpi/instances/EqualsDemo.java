package ua.ipt.kpi.instances;

import java.util.Objects;

public class EqualsDemo {
    public static void main(String[] args) {
        System.out.println(new Point(1, 1, null).equals(new Point(1, 1, null)));
        System.out.println(new Point(1, 1, null).equals(new ParentPoint(1, 1, null)));
        System.out.println(new Point(1, 1, null).equals(new Point(1, 2, null)));
        System.out.println(new ParentPoint(1, 1, null).equals(new ChildPoint(1, 1, null, 1)));
    }
}

interface Color {
    String getColor();
}

class Point {
    private final int x;
    private final int y;

    private final Color color;

    public Point(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Point that = (Point) o;
        return x == that.x &&
                y == that.y &&
                Objects.equals(color, that.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, color);
    }
}

class ParentPoint {
    private final int x;
    private final int y;

    private final Color color;

    public ParentPoint(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ParentPoint that = (ParentPoint) o;
        return x == that.x &&
                y == that.y &&
                Objects.equals(color, that.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, color);
    }
}

class ChildPoint extends ParentPoint {
    private final int size;

    public ChildPoint(int x, int y, Color color, int size) {
        super(x, y, color);
        this.size = size;
    }
}

class Transaction {
    private final long id;

    private final String status;

    // Other fields

    public Transaction(long id, String status) {
        this.id = id;
        this.status = status;
    }
}


