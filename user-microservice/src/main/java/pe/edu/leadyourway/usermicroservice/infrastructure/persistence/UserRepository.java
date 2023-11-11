package pe.edu.leadyourway.usermicroservice.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.leadyourway.usermicroservice.domain.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


}
