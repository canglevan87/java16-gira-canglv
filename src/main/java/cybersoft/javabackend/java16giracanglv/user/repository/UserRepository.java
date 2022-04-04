package cybersoft.javabackend.java16giracanglv.user.repository;


import cybersoft.javabackend.java16giracanglv.role.model.GiraUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface UserRepository extends JpaRepository<GiraUser, UUID> {


    Optional<GiraUser> findByUsername(String username);

    Optional<GiraUser> findByEmail(String email);
}
