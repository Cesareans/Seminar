package seminar.config.security.entrypoint;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Cesare
 */
@Component
public class UnauthorizedEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException {
        String typeHeader = "X-Requested-With";
        String ajaxFlag = "XMLHttpRequest";
        String adminPrefix = "/admin";
        String url = request.getRequestURI();
        if (ajaxFlag.equals(request.getHeader(typeHeader))) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, e.getMessage());
        } else if (url.startsWith(adminPrefix)) {
            response.sendRedirect("/admin/login");
        } else {
            response.sendRedirect("/login");
        }

    }
}
