package eu.rogowski.dealer.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class ServerSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder)
            throws Exception {
        authenticationManagerBuilder
                .inMemoryAuthentication()
                .withUser("user")
                .password("password")
                .roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http)
            throws Exception {
        http.csrf().disable()
                .requiresChannel()
                .anyRequest()
                .requiresSecure()

                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .authorizeRequests()
                .antMatchers("/orders?ordersId").permitAll()
                .antMatchers("/orders").hasAnyRole("USER", "ADMIN");
    }
}