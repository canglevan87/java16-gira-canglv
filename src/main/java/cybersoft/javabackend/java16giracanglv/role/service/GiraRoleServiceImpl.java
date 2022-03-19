package cybersoft.javabackend.java16giracanglv.role.service;

import cybersoft.javabackend.java16giracanglv.common.BaseMapper;
import cybersoft.javabackend.java16giracanglv.role.mapper.RoleMapper;
import cybersoft.javabackend.java16giracanglv.role.model.GiraRole;
import cybersoft.javabackend.java16giracanglv.role.repository.GiraRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GiraRoleServiceImpl implements GiraRoleService {

   @Autowired
    private GiraRoleRepository giraRoleRepository;



    @Override
    public List<GiraRole> FindAll() {
        return giraRoleRepository.findAll();
    }

    @Override
    public  GiraRoleDTO save(GiraRoleDTO giraRoleDTO) {
        //map dto to entity
        GiraRole giraRole = RoleMapper.INSTANCE.mapDtoEntity(giraRoleDTO);;
        giraRoleRepository.save(giraRole);
        return giraRoleDTO;
    }
}
