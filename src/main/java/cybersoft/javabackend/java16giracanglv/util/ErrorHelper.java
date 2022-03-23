package cybersoft.javabackend.java16giracanglv.util;

import org.springframework.validation.BindingResult;

import java.util.List;

public class ErrorHelper {
    public static List<String> getErrorMessages(BindingResult errorMessages) {
        return errorMessages.getAllErrors()
                .stream().map(error -> error.getDefaultMessage())
                .collect(java.util.stream.Collectors.toList());

    }
}
