package pe.edu.leadyourway.usermicroservice.interfaces.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.leadyourway.usermicroservice.domain.mapping.UserMapper;
import pe.edu.leadyourway.usermicroservice.domain.service.UserService;
import pe.edu.leadyourway.usermicroservice.interfaces.rest.resources.CreateUserResource;
import pe.edu.leadyourway.usermicroservice.interfaces.rest.resources.UserResource;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UsersController {

    private final UserService userService;
    private final UserMapper mapper;

    public UsersController(UserService userService, UserMapper mapper) {
        this.userService = userService;
        this.mapper = mapper;
    }

    @GetMapping("userId")
    public ResponseEntity<UserResource> getUserById(@PathVariable Long userId) {
        return new ResponseEntity<>(mapper.toResource(userService.getById(userId)), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<UserResource>> getAllUsers() {

        return new ResponseEntity<>(mapper.modelListPage(userService.getAll()), HttpStatus.OK);
    }
    @PostMapping()
    public ResponseEntity<UserResource> createUser(@RequestBody CreateUserResource resource) {
        return new ResponseEntity<>(mapper.toResource(userService.create(mapper.toModel(resource))), HttpStatus.CREATED);
    }
}
