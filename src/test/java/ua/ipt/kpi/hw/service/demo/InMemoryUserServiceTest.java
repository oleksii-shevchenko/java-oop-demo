package ua.ipt.kpi.hw.service.demo;

import java.util.HashSet;
import java.util.concurrent.ThreadLocalRandom;
import org.junit.Before;
import org.junit.Test;
import ua.ipt.kpi.hw.DomainGenerator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class InMemoryUserServiceTest {
    private static final int DEFAULT_ITERATIONS = 512;
    
    private InMemoryUserService userService;
    
    @Before
    public void setUp() {
        userService = new InMemoryUserService();
    }

    @Test
    public void emptyOkTest() {
        assertNull(userService.get(ThreadLocalRandom.current().nextLong()));
    }

    @Test
    public void uniqueIdTest() {
        var ids = new HashSet<Long>();
        for (int i = 0; i < DEFAULT_ITERATIONS; i++) {
            var id = userService.register(DomainGenerator.randomUser());
            assertFalse(ids.contains(id));
            ids.add(id);
        }
    }

    @Test
    public void regularPathOkTest() {
        var user = DomainGenerator.randomUser();

        var id = userService.register(user);

        assertTrue(userService.exists(id));
        assertEquals(user, userService.get(id));
        assertEquals(user, userService.delete(id));
        assertFalse(userService.exists(id));
        assertNull(userService.get(id));
    }

    @Test
    public void deleteExceptionTest() {
        try {
            userService.delete(ThreadLocalRandom.current().nextLong());
            fail();
        } catch (Exception e) {
            // Expected
        }
    }
}