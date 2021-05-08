package com.spring.devblog.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

//    variavel estática contendo as uri's' que não vão precisar de autenticação
    private static final String[] AUTH_LIST= {
        "/",
        "/posts",
        "/posts/{id}",
    };

// permite acesso a todas as uri's contidas na variavel auth_list' e a pg de log in, qq outro qualuqer resquest precisa de autenticação
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.csrf().disable().authorizeRequests()
            .antMatchers(AUTH_LIST).permitAll()
            .anyRequest().authenticated()
            .and().formLogin().permitAll()
            .and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.inMemoryAuthentication()
            .withUser("amanda").password("{noop}123").roles("ADMIN");
    }


//    // exemplo de método para a permissão das ´pastas estáticas
//    @Override
//    public void configure(WebSecurity web) throws Exception{
//        web.ignoring().antMatchers("/bootstrap/**");
//    }

}
