package com.cletus.facturacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configurerGlobal(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception{

        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        User.UserBuilder users = User.builder().passwordEncoder(encoder::encode);

        authenticationManagerBuilder.inMemoryAuthentication().withUser(users.username("admin").password("12345").roles("ADMIN","USER"))
                .withUser(users.username("ana").password("12345").roles("USER"));

    }

}
