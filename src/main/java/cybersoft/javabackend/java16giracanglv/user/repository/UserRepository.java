package cybersoft.javabackend.java16giracanglv.user.repository;


import cybersoft.javabackend.java16giracanglv.role.model.GiraUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface UserRepository extends JpaRepository<GiraUser, UUID> {


    @Query ("select u from GiraUser u left join fetch u.groups where u.username = ?1")
    Optional<GiraUser> findByUsername(String username);

    Optional<GiraUser> findByEmail(String email);
}
