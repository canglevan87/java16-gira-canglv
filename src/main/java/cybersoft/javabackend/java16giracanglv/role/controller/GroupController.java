package cybersoft.javabackend.java16giracanglv.role.controller;

import cybersoft.javabackend.java16giracanglv.role.dto.GiraGroupDTO;
import cybersoft.javabackend.java16giracanglv.role.dto.GiraGroupRoleDTO;
import cybersoft.javabackend.java16giracanglv.role.service.GiraGroupService;
import cybersoft.javabackend.java16giracanglv.util.ResponseHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/group")
public class GroupController {
    @Autowired
    GiraGroupService giraGroupService;

    @GetMapping
    public Object findGroup(){
        log.info("findGroup");
        List<GiraGroupDTO> groupDTOS = giraGroupService.findAll();
        return ResponseHelper.getResponeseEntity(groupDTOS, HttpStatus.OK);
    }
    @PostMapping
    public Object createGroup(@Valid @RequestBody GiraGroupDTO giraGroupDTO, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return  ResponseHelper.getErrorMessage(HttpStatus.CREATED,bindingResult);
        }
        GiraGroupDTO body = giraGroupService.crateGroup(giraGroupDTO);
        return ResponseHelper.getResponeseEntity(body, HttpStatus.CREATED);
    }

    @PostMapping ("add-role/{groupId}/{roleId}")
    public Object  addRole (@PathVariable("groupId") String groupId, @PathVariable("roleId") String roleId){
        GiraGroupRoleDTO giraGroupDTO = giraGroupService.addRole(groupId, roleId);
        if (giraGroupDTO == null){
            return ResponseHelper.getErrorString("Role is not exist", HttpStatus.BAD_REQUEST);
        }
        return ResponseHelper.getResponeseEntity(giraGroupDTO, HttpStatus.OK);
    }

    @PostMapping ("remove-role/{groupId}/{roleId}")
    public Object  removeRole (@PathVariable("groupId") String groupId, @PathVariable("roleId") String roleId){
        GiraGroupRoleDTO giraGroupDTO = giraGroupService.removeRole(groupId, roleId);
        if (giraGroupDTO == null){
            return ResponseHelper.getErrorString("Role is not exist", HttpStatus.BAD_REQUEST);
        }
        return ResponseHelper.getResponeseEntity(giraGroupDTO, HttpStatus.OK);
    }



}
