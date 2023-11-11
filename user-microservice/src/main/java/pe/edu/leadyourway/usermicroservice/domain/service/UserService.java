package pe.edu.leadyourway.usermicroservice.domain.service;

import pe.edu.leadyourway.usermicroservice.domain.model.User;

import java.util.List;

public interface UserService {

    User create(User user);
    User getById(Long id);
    List<User> getAll();
}
