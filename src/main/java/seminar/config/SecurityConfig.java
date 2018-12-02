package seminar.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import seminar.config.entrypoint.UnauthorizedEntryPoint;
import seminar.config.handler.AjaxAuthFailureHandler;
import seminar.config.handler.AjaxAuthSuccessHandler;

/**
 * @author Cesare
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final AjaxAuthFailureHandler ajaxAuthFailureHandler;
    private final AjaxAuthSuccessHandler ajaxAuthSuccessHandler;
    private final UnauthorizedEntryPoint unauthorizedEntryPoint;

    @Autowired
    public SecurityConfig(AjaxAuthFailureHandler ajaxAuthFailureHandler, AjaxAuthSuccessHandler ajaxAuthSuccessHandler, UnauthorizedEntryPoint unauthorizedEntryPoint) {
        this.ajaxAuthFailureHandler = ajaxAuthFailureHandler;
        this.ajaxAuthSuccessHandler = ajaxAuthSuccessHandler;
        this.unauthorizedEntryPoint = unauthorizedEntryPoint;
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //Page Filter
        http.authorizeRequests()
                .antMatchers("/", "/login", "/admin/login").permitAll()
                .antMatchers("/admin/**").hasRole("admin")
                .antMatchers("/student/**", "/student").hasRole("student")
                .antMatchers("/teacher/**", "/teacher").hasRole("teacher")
                .anyRequest().authenticated();
        //Admin login config
        http.formLogin()
                .loginPage("/admin/login").loginProcessingUrl("/admin/login")
                .usernameParameter("name").passwordParameter("password")
                .successHandler(ajaxAuthSuccessHandler).failureHandler(ajaxAuthFailureHandler)
                .permitAll();
        //User login config
        http.formLogin()
                .loginPage("/login").loginProcessingUrl("/login")
                .usernameParameter("username").passwordParameter("password")
                .successHandler(ajaxAuthSuccessHandler).failureHandler(ajaxAuthFailureHandler)
                .permitAll();
        //Disable CSRF security
        http.csrf().disable();
        //Enable iframe
        http.headers().frameOptions().sameOrigin();
        //Enable Ajax login fail exception handler
        http.exceptionHandling().authenticationEntryPoint(unauthorizedEntryPoint);
    }

    @Override
    public void configure(WebSecurity web) {
        //Enable static resource access
        //TODO:More specified matcher for static resources should be added here.
        web.ignoring().antMatchers("/static/**");
    }
}
