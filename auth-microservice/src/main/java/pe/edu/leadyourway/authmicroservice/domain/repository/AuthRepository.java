package pe.edu.leadyourway.authmicroservice.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.leadyourway.authmicroservice.infrastructure.entity.AuthEntity;

@Repository
public interface AuthRepository extends JpaRepository<AuthEntity, Long> {
}
