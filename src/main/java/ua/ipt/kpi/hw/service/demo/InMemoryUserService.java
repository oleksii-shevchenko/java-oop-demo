package ua.ipt.kpi.hw.service.demo;

import ua.ipt.kpi.hw.domain.User;
import ua.ipt.kpi.hw.service.UserService;

/**
 * Application must be single threaded, so do not care about synchronization
 */
public class InMemoryUserService implements UserService {
    @Override
    public long register(User user) {
        return 0;
    }

    @Override
    public User get(long id) {
        return null;
    }

    @Override
    public User delete(long id) {
        return null;
    }

    @Override
    public boolean exists(long id) {
        return false;
    }
}
