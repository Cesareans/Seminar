package seminar.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import seminar.config.security.entrypoint.UnauthorizedEntryPoint;
import seminar.config.security.handler.AjaxAuthFailureHandler;
import seminar.config.security.handler.AjaxAuthSuccessHandler;
import seminar.service.implement.UserDetailsServiceImpl;

/**
 * @author Cesare
 */
@Configuration
@Order(2)
public class UserSecurityConfig extends WebSecurityConfigurerAdapter {
    private final UserDetailsServiceImpl userDetailsService;
    private final AjaxAuthFailureHandler ajaxAuthFailureHandler;
    private final AjaxAuthSuccessHandler ajaxAuthSuccessHandler;
    private final UnauthorizedEntryPoint unauthorizedEntryPoint;

    @Autowired
    public UserSecurityConfig(UserDetailsServiceImpl userDetailsService, AjaxAuthFailureHandler ajaxAuthFailureHandler, AjaxAuthSuccessHandler ajaxAuthSuccessHandler, UnauthorizedEntryPoint unauthorizedEntryPoint) {
        this.userDetailsService = userDetailsService;
        this.ajaxAuthFailureHandler = ajaxAuthFailureHandler;
        this.ajaxAuthSuccessHandler = ajaxAuthSuccessHandler;
        this.unauthorizedEntryPoint = unauthorizedEntryPoint;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //Page Filter
        http.authorizeRequests()
                .antMatchers("/student/**").hasRole("student")
                .antMatchers("/teacher/**").hasRole("teacher");
        //User log config
        http.formLogin()
                .loginPage("/login").loginProcessingUrl("/login")
                .usernameParameter("account").passwordParameter("password")
                .successHandler(ajaxAuthSuccessHandler).failureHandler(ajaxAuthFailureHandler)
                .permitAll();
        http.logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login");

        //Disable CSRF security
        http.csrf().disable();
        //Enable iframe
        http.headers().frameOptions().sameOrigin();
        //Enable Ajax login fail exception handler
        http.exceptionHandling().authenticationEntryPoint(unauthorizedEntryPoint);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }
    //
//    @Override
//    public void configure(WebSecurity web) {
//        //Enable static resource access
//        //TODO:More specified matcher for static resources should be added here.
//        web.ignoring().antMatchers("/static/**");
//    }
}
