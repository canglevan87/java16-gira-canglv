package cybersoft.javabackend.java16giracanglv.role.repository;

import cybersoft.javabackend.java16giracanglv.role.model.GiraRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface GiraRoleRepository extends JpaRepository<GiraRole, UUID> {

}
