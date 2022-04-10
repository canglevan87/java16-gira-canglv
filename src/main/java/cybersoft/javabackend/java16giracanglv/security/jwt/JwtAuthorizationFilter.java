package cybersoft.javabackend.java16giracanglv.security.jwt;

import org.springframework.security.web.header.Header;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtAuthorizationFilter extends OncePerRequestFilter {
    @Autowired
    private JwtHelper jwtHelper;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
    // TODO Auto-generated method stub
     String prefix = "Bearer ";
        String jwt  =  request.getHeader("Authorization");


     if(jwt ==null ){
        filterChain.doFilter(request, response);
     }
    String token = jwt.substring(prefix.length(),jwt.length());
    }
    if(jwtHelper.validate(token)){
        //get credentials and set security context
        filterChain.doFilter(request, response);
    }
    else{
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
    }
}
}
