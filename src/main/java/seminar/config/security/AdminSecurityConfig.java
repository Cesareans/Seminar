package seminar.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import seminar.config.security.entrypoint.UnauthorizedEntryPoint;
import seminar.config.security.handler.AjaxAuthFailureHandler;
import seminar.config.security.handler.AjaxAuthSuccessHandler;

/**
 * @author Cesare
 */
@Configuration
@Order(1)
public class AdminSecurityConfig extends WebSecurityConfigurerAdapter {
    private final AjaxAuthFailureHandler ajaxAuthFailureHandler;
    private final AjaxAuthSuccessHandler ajaxAuthSuccessHandler;
    private final UnauthorizedEntryPoint unauthorizedEntryPoint;

    @Autowired
    public AdminSecurityConfig(AjaxAuthFailureHandler ajaxAuthFailureHandler, AjaxAuthSuccessHandler ajaxAuthSuccessHandler, UnauthorizedEntryPoint unauthorizedEntryPoint) {
        this.ajaxAuthFailureHandler = ajaxAuthFailureHandler;
        this.ajaxAuthSuccessHandler = ajaxAuthSuccessHandler;
        this.unauthorizedEntryPoint = unauthorizedEntryPoint;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //Page Filter
        http.antMatcher("/admin/**")
                .authorizeRequests()
                .anyRequest()
                .hasRole("admin");
        //Admin log config
        http.formLogin()
                .loginPage("/admin/login").loginProcessingUrl("/admin/login")
                .usernameParameter("account").passwordParameter("password")
                .successHandler(ajaxAuthSuccessHandler).failureHandler(ajaxAuthFailureHandler)
                .permitAll();
        http.logout()
                .logoutUrl("/admin/logout")
                .logoutSuccessUrl("/admin/login");

        //Disable CSRF security
        http.csrf().disable();
        //Enable iframe
        http.headers().frameOptions().sameOrigin();
        //Enable Ajax login fail exception handler
        http.exceptionHandling().authenticationEntryPoint(unauthorizedEntryPoint);
    }
}
