package web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import web.model.User;
import web.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

@Component
public class SuccessUserHandler implements AuthenticationSuccessHandler {

    final UserService userService;

    @Autowired
    public SuccessUserHandler(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest,
                                        HttpServletResponse httpServletResponse,
                                        Authentication authentication) throws IOException {
        User user = (User) authentication.getPrincipal();
        Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
        if (roles.contains("ROLE_ADMIN")) {
        //httpServletResponse.sendRedirect("/admin");
            httpServletResponse.sendRedirect("/admin/test123");
        } else if (roles.contains("ROLE_USER")) {
            httpServletResponse.sendRedirect("/userpage");
        } else {
            httpServletResponse.sendRedirect("/net_dostupa");
        }
    }
}