package cybersoft.javabackend.java16giracanglv.user.controller;

import cybersoft.javabackend.java16giracanglv.role.model.GiraUser;
import cybersoft.javabackend.java16giracanglv.user.dto.GiraUserDTO;
import cybersoft.javabackend.java16giracanglv.user.service.UserService;
import cybersoft.javabackend.java16giracanglv.util.ResponseHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public Object createUser(@RequestBody @Valid GiraUserDTO giraUserDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return  ResponseHelper.getErrorMessage(HttpStatus.CREATED,bindingResult);
        }
            GiraUserDTO newUser = userService.createUser(giraUserDTO);
            return ResponseHelper.getResponeseEntity(newUser, HttpStatus.CREATED);


    }
}




