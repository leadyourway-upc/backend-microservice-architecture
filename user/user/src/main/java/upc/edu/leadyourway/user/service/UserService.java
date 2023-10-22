package upc.edu.leadyourway.user.service;

import upc.edu.leadyourway.user.model.User;

import java.util.List;

public interface UserService {
    public abstract User createUser(User user);
    public abstract User getUserById(Long user_id);
    public abstract User updateUser(User user);
    public abstract void deleteUser(Long user_id);
    public abstract List<User> getAllUsers();
}
