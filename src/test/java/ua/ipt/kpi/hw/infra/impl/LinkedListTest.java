package ua.ipt.kpi.hw.infra.impl;

import java.util.Objects;
import org.junit.Test;
import ua.ipt.kpi.hw.infra.List;

import static org.junit.Assert.*;

public class LinkedListTest {
    private static class Point {
        private final int x;
        private final int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Point point = (Point) o;
            return x == point.x &&
                    y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    @Test
    public void addNullFailTest() {
        try {
            new LinkedList<>().add(null);
        } catch (Exception e) {
            // Expected
        }
    }

    @Test
    public void addOkTest() {
        List<Point> list = new LinkedList<>();
        list.add(new Point(1, 3));

        assertTrue(list.contains(new Point(1, 3)));
        assertFalse(list.contains(new Point(2, 4)));
    }

    @Test
    public void containsNullFailTest() {
        try {
            new LinkedList<>().contains(null);
            fail();
        } catch (Exception e) {
            // Expected
        }
        try {
            List<Point> list = new LinkedList<>();
            list.add(new Point(1, 4));
            list.contains(null);
        } catch (Exception e) {
            // Expected
        }
    }

    @Test
    public void getByIndexOkTest() {
        List<Point> list = new LinkedList<>();
        list.add(new Point(2, 4));
        list.add(new Point(1, 1));
        list.add(new Point(6, 2));

        assertEquals(new Point(2, 4), list.get(0));
        assertEquals(new Point(1, 1), list.get(1));
        assertEquals(new Point(6, 2), list.get(2));
    }

    @Test
    public void getByIndexFailTest() {
        try {
            new LinkedList<>().get(0);
            fail();
        } catch (Exception e) {
            // Expected
        }
        try {
            LinkedList<Point> list = new LinkedList<>();
            list.add(new Point(1, 1));
            list.get(1);
        } catch (Exception e) {
            // Expected
        }
    }

    @Test
    public void sizeOkTest() {
        List<Object> list = new LinkedList<>();
        assertEquals(0, list.size());
        list.add(new Object());
        list.add(new Object());
        assertEquals(2, list.size());
    }

    @Test
    public void deleteByElementOkTest() {
        List<Point> list = new LinkedList<>();

        list.add(new Point(1, 2));
        list.add(new Point(3, 3));
        list.add(new Point(3, 3));
        list.add(new Point(4, 5));
        list.add(new Point(3, 3));
        list.add(new Point(1, 1));

        assertEquals(6, list.size());

        Point ref = new Point(3, 3);
        Point del = list.delete(ref);

        assertSame(ref, del);
        assertEquals(3, list.size());
        assertNotEquals(ref, list.get(1));
    }

    @Test
    public void deleteByValueFailTest() {
        try {
            List<Point> list = new LinkedList<>();
            list.add(new Point(0, 0));
            list.delete(null);
        } catch (Exception e) {
            // Expected
        }
    }

    @Test
    public void deleteByIndexOkTest() {
        List<Point> list = new LinkedList<>();

        list.add(new Point(1, 5));
        list.add(new Point(89, 9));
        list.add(new Point(-1, 1));

        assertEquals(3, list.size());

        Point ref = new Point(89, 9);
        Point del = list.delete(1);

        assertEquals(2, list.size());
        assertEquals(ref, del);
        assertNotEquals(ref, list.get(1));
    }

    @Test
    public void deleteByIndexFailTest() {
        try {
            List<Object> list = new LinkedList<>();
            list.add(new Object());
            list.add(new Object());
            list.delete(8);
        } catch (Exception e) {
            // Expected
        }
    }

    @Test
    public void updateFailTest() {
        try {
            List<Object> list = new LinkedList<>();
            list.add(new Object());
            list.update(3, new Object());
        } catch (Exception e) {
            // Expected
        }
        try {
            List<Object> list = new LinkedList<>();
            list.add(new Object());
            list.update(0, null);
        } catch (Exception e) {
            // Expected
        }
    }

    @Test
    public void updateOkTest() {
        List<Point> list = new LinkedList<>();
        list.add(new Point(1, 1));
        list.add(new Point(3, 3));
        list.add(new Point(2, 2));

        Point ref = new Point(5, 5);
        Point upd = list.update(1, ref);

        assertEquals(ref, list.get(1));
        assertEquals(new Point(3, 3), upd);
    }

    @Test
    public void processorOkTest() {
        List<Point> list = new LinkedList<>();
        list.add(new Point(1, 5));
        list.add(new Point(2, 6));
        list.add(new Point(3, 7));

        List<Integer> intList = new LinkedList<>();
        intList.add(5);
        intList.add(7);

        List<Integer> processed = list.process(point -> {
            if (point.getX() % 2 == 0) {
                return point.getY();
            } else {
                return null;
            }
        });

        assertEquals(intList, processed);
    }
}
