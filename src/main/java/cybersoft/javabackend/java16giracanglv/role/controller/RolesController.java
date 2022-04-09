package cybersoft.javabackend.java16giracanglv.role.controller;

import cybersoft.javabackend.java16giracanglv.role.model.GiraRole;
import cybersoft.javabackend.java16giracanglv.role.service.GiraRoleDTO;
import cybersoft.javabackend.java16giracanglv.role.service.GiraRoleService;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/roles")
public class RolesController {

    @Autowired
    GiraRoleService giraRoleService;

    @GetMapping
    public Object findRoles(){
        List<GiraRole> roles = giraRoleService.FindAll();
      return new ResponseEntity<>(roles, HttpStatus.OK);
    }
    @PostMapping
    public Object createRoles(@Valid @RequestBody GiraRoleDTO giraRoleDTO){
        GiraRoleDTO body = giraRoleService.save(giraRoleDTO);
        return new ResponseEntity<>(body, HttpStatus.CREATED);
    }



}

