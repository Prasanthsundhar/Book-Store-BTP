package customer.demo_cap.config;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {
    // @Override
    // public void commence(HttpServletRequest request,
    // HttpServletResponse response,
    // AuthenticationException authException) throws IOException ServletException {
    // // Customize the response
    // response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
    // response.getWriter().write("Unauthorized access");
    // }

    @Override
    public void commence(jakarta.servlet.http.HttpServletRequest request,
            jakarta.servlet.http.HttpServletResponse response, AuthenticationException authException)
            throws IOException, ServletException {
        // TODO Auto-generated method stub
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.getWriter().write("Unauthorized access");
    }
}
