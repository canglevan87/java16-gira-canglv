package cybersoft.javabackend.java16giracanglv.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
    @GetMapping(value = {"","/welcome"})


    public String welcome() {
        return "Welcome to Java Backendss";
    }
}
