package cybersoft.javabackend.java16giracanglv.controller;

import cybersoft.javabackend.java16giracanglv.role.model.GiraRole;
import cybersoft.javabackend.java16giracanglv.role.service.GiraRoleDTO;
import cybersoft.javabackend.java16giracanglv.role.service.GiraRoleService;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/roles")
public class RolesController {

    @Autowired
    GiraRoleService giraRoleService;

    @GetMapping
    public Object findRoles(){
        List<GiraRole> roles = giraRoleService.FindAll();
      return new ResponseEntity<>(roles, HttpStatus.OK);
    }
    @PostMapping
    public Object createRoles(@Valid @RequestBody GiraRoleDTO giraRoleDTO , BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getAllErrors()
                    .stream().map(t -> t.getDefaultMessage())
                    .collect(Collectors.toList())
                    , HttpStatus.BAD_REQUEST);
        }

        GiraRoleDTO body = giraRoleService.save(giraRoleDTO);
        return new ResponseEntity<>(body, HttpStatus.CREATED);
    }



}

