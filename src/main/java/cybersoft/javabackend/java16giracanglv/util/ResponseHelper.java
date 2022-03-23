package cybersoft.javabackend.java16giracanglv.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class ResponseHelper {
    public static ResponseEntity <Object> getResponeseEntity (Object obj, HttpStatus Status){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("data", obj);
        map.put("status", Status.value());
        map.put("content", obj);
        map.put("timestamp", LocalDateTime.now());
        return new ResponseEntity<Object>(map, Status);

    }

    public static ResponseEntity <Object> getErrorMessage (HttpStatus Status,BindingResult bindingResult ){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("data", null);
        map.put("status", Status.value());
        map.put("errors", ErrorHelper.getErrorMessages(bindingResult));
        map.put("timestamp", LocalDateTime.now());
        return new ResponseEntity<Object>(map, Status);

    }
    public static ResponseEntity <Object> getErrorString (String error,HttpStatus Status ){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("data", null);
        map.put("status", Status.value());
        map.put("errors", error);
        map.put("timestamp", LocalDateTime.now());
        return new ResponseEntity<Object>(map, Status);

    }
}
