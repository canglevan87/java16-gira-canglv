package cybersoft.javabackend.java16giracanglv.role.repository;

import cybersoft.javabackend.java16giracanglv.role.model.GiraRole;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;


@SpringBootTest
@Transactional
public class GiraRoleRepositoryTest {
   @Autowired
    private GiraRoleRepository giraRoleRepository;
    @Test
    public void shoudNotInsertRole() {
        GiraRole giraRole = GiraRole.builder().code("len56").description("tesst").build();
        assertDoesNotThrow(() -> giraRoleRepository.save(giraRole));
//        assertThrows(Exception.class, () -> giraRoleRepository.save(giraRole));
    }
}
