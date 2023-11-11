package pe.edu.leadyourway.usermicroservice.application.internal.services;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.springframework.stereotype.Service;
import pe.edu.leadyourway.usermicroservice.domain.exception.ResourceNotFoundException;
import pe.edu.leadyourway.usermicroservice.domain.exception.ResourceValidationException;
import pe.edu.leadyourway.usermicroservice.domain.model.User;
import pe.edu.leadyourway.usermicroservice.domain.service.UserService;
import pe.edu.leadyourway.usermicroservice.infrastructure.persistence.UserRepository;

import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    private final static String ENTITY = "User";

    private final UserRepository userRepository;
    private final Validator validator;

    public UserServiceImpl(UserRepository userRepository, Validator validator) {
        this.userRepository = userRepository;
        this.validator = validator;
    }

    @Override
    public User getById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(ENTITY, id));
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User create(User user) {
        Set<ConstraintViolation<User>> violations = validator.validate(user);

        if(!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return userRepository.save(user);
    }
}
