package seminar.config.entrypoint;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Cesare
 */
@Component
public class UnauthorizedEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        String typeHeader = "X-Requested-With";
        String ajaxFlag = "XMLHttpRequest";
        if (ajaxFlag.equals(request.getHeader(typeHeader))) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, e.getMessage());
        } else {
            response.sendRedirect("/admin/login");
        }
    }
}
