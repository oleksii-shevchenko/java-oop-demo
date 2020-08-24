package ua.ipt.kpi.hw.service;

import ua.ipt.kpi.hw.domain.User;

public interface UserService {
    /**
     * Perform validation of the domain object
     * and register user in case everything is
     * valid.
     * @param user User to register.
     * @return Id of the registered user.
     */
    long register(User user);

    /**
     * Return stored user by id. In case there
     * is no user with such id MUST return null.
     * @param id User id
     * @return User object
     */
    User get(long id);

    /**
     * Delete user by id. In case there is no user
     * with such id MUST thrown an {@link RuntimeException}.
     * @param id User id
     * @return Deleted user object
     */
    User delete(long id);

    /**
     * Check that user with such id has been already registered.
     * @param id User id
     * @return Presence of the user in store
     */
    boolean exists(long id);
}
