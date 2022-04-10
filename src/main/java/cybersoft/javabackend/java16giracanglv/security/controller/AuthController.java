package cybersoft.javabackend.java16giracanglv.security.controller;


import cybersoft.javabackend.java16giracanglv.security.dto.LoginDTO;
import cybersoft.javabackend.java16giracanglv.security.service.AuthService;
import cybersoft.javabackend.java16giracanglv.util.ResponseHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/auth")

public class AuthController {
    @Autowired
    private AuthService authService;
    @PostMapping("/login")
    public Object login(@RequestBody @Valid LoginDTO dto, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return ResponseHelper.getErrorMessage(HttpStatus.BAD_REQUEST,bindingResult);
        }
        String token = authService.login(dto);
        if (token == null) {
            return ResponseHelper.getErrorString("Invalid username or password", HttpStatus.BAD_REQUEST);
        } else {
            return ResponseHelper.getResponeseEntity(token, HttpStatus.OK);
        }




    }
}
