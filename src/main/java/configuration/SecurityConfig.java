package configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import service.UserService;
import service.UserServiceImpl;

import javax.sql.DataSource;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private DataSource dataSource;

    @Bean("authenticationManager")
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Autowired
    private UserService userService;

        @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.userDetailsService(userService);
    }

    @Bean
    public AuthenticationSuccessHandler myAuthenticationSuccessHandler() {
        return new MySimpleUrlAuthenticationSuccessHandler();
    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {

        http.authorizeRequests().antMatchers(
                "/product/productPage",
                "/welcome/homepage",
                "/downloadFile/infoPageIcon.png",
                "/downloadFile/cartPageIcon.png",
                "/downloadFile/homePageIcon.png",
                "/product/item*",
                "/welcome/aboutPage",
                "/user/login",
                "/user/registerUser",
                "/user/addUser",
                "/user/addManager",
                "/user/registerManager",
                "/user/thankForRegister"

        ).permitAll();
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/role/**").hasRole("MANAGER")
                .antMatchers("/anonymous*").anonymous()
                .antMatchers("/login*").permitAll()
               .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .loginPage("/login.html")
//                .loginProcessingUrl("/login")
//                .successHandler(myAuthenticationSuccessHandler())
                .and()
                .formLogin()
                .loginPage("/user/login")
                .loginProcessingUrl("/user/login")
                .defaultSuccessUrl("/product/productPage", false)
                .usernameParameter("name")
                .passwordParameter("password")
                .successHandler(myAuthenticationSuccessHandler())
                .failureHandler(authenticationFailureHandler())
                .and()
                .logout()
                .logoutUrl("/perform_logout")
                .deleteCookies("JSESSIONID")
                .logoutSuccessHandler(logoutSuccessHandler());
    }


    @Bean
    public AuthenticationFailureHandler authenticationFailureHandler() {
        return new CustomAuthenticationFailureHandler();
    }

    @Bean
    public LogoutSuccessHandler logoutSuccessHandler() {
        return new CustomLogoutSuccessHandler();
    }

    @Bean
    public AccessDeniedHandler accessDeniedHandler() {
        return new CustomAccessDeniedHandler();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
