package com.huotn.huosecritytoken.config;

import com.huotn.huosecritytoken.handle.MyAuthenticationFailureHandler;
import com.huotn.huosecritytoken.handle.MyAuthenticationSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 * @author:leichengyang
 * @desc:com.huotn.huosecritytoken.config
 * @date:2020-04-29
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {
    @Autowired
    private MyAuthenticationSuccessHandler myAuthenticationSuccessHandler;

    @Autowired
    private MyAuthenticationFailureHandler myAuthenticationFailureHandler;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .loginPage("/authentication/form")
                .successHandler(myAuthenticationSuccessHandler)
                .failureHandler(myAuthenticationFailureHandler);

        http.authorizeRequests()
                .antMatchers("/login", "/authentication/form").permitAll()
                .anyRequest().authenticated()
                .and().csrf().disable();
    }
}

