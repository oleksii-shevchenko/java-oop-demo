package ua.ipt.kpi.task;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayTaskManualTest {
    private final int DEFAULT_LENGTH = 64;

    @Test
    public void maxTest() {
        int limit = 1024;
        int[] ints = ThreadLocalRandom.current()
                .ints(DEFAULT_LENGTH, 0, limit)
                .toArray();

        int max = ThreadLocalRandom.current().nextInt(limit, 2 * limit);
        ints[ThreadLocalRandom.current().nextInt(0, DEFAULT_LENGTH)] = max;
        assertEquals(max, ArrayTaskManual.maxElement(ints));
    }

    @Test
    public void maxTwoDimensionTest() {
        int limit = 2048;
        int[][] ints = new int[DEFAULT_LENGTH][];

        for (int i = 0; i < limit; i++) {
            ints[i] = ThreadLocalRandom.current()
                    .ints(DEFAULT_LENGTH, 0, limit)
                    .toArray();
        }

        int max = ThreadLocalRandom.current().nextInt(limit, 2 * limit);

        int x = ThreadLocalRandom.current().nextInt(0, DEFAULT_LENGTH);
        int y = ThreadLocalRandom.current().nextInt(0, DEFAULT_LENGTH);
        ints[x][y] = max;
        assertEquals(max, ArrayTaskManual.maxElement(ints));
    }

    @Test
    public void fillTest() {
        double[] array = ThreadLocalRandom.current()
                .doubles(DEFAULT_LENGTH)
                .toArray();

        double val = ThreadLocalRandom.current().nextDouble();

        ArrayTaskManual.fill(array, val);

        for (double v : array) {
            assertEquals(val, v, 0.1);
        }
    }

    @Test
    public void findTest() {
        int limit = 1024;

        int[] ints = ThreadLocalRandom.current()
                .ints(DEFAULT_LENGTH, 0, limit)
                .toArray();

        int val = ThreadLocalRandom.current().nextInt(0, 2 * limit);
        int x = ThreadLocalRandom.current().nextInt(0, DEFAULT_LENGTH);

        ints[x] = val;
        assertEquals(x, ArrayTaskManual.findOrNegative(ints, val));
    }

    @Test
    public void sortedTest() {
        int[] ints = ThreadLocalRandom.current()
                .ints(DEFAULT_LENGTH)
                .toArray();

        int[] sorted = Arrays.copyOf(ints, ints.length);

        Arrays.sort(sorted);
        ArrayTaskManual.sort(ints);

        assertArrayEquals(sorted, ints);
    }
}
