package com.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class ProjectConfig extends WebSecurityConfigurerAdapter {
  /**
   * three important contracts:
   *
   *  1- UserDetails
   *  2- UserDetailsService -> UserDetailsManager: Manager add more details and functionality to UserDetailsService
   *                           Good Example of interface segregation
   *  3- PasswordEncoder
   */

  /**
   * UserDetails, username, password, list of authorities => represent the user
   * UserDetailsService -> the contract used to load users from somewhere, it can be from db, inMemory db, ldap etc..
   * PasswordEncoder: 2 behaviours -> encrypt password, matching password to see if pwd is correct or not
   */

  /**
   * Collection<? extends GrantedAuthority> getAuthorities(); ==> permission of actions that user
   * can do
   */

  @Bean
  public UserDetailsService userDetailsService() {
    var manager = new InMemoryUserDetailsManager();
    UserDetails u1 = User.withUsername("bill").password("12345").roles("ADMIN").authorities("write")
        .build();
    UserDetails u2 = User.withUsername("john").password("12345").roles("MANAGER")
        .authorities("read").build();

    manager.createUser(u1);
    manager.createUser(u2);
    return manager;
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    PasswordEncoder instance = NoOpPasswordEncoder.getInstance();
    return instance;
  }

  // to define which endpoint can be access by whom ?
  // you can you Method / Path or both of them
  protected void configure(HttpSecurity http) throws Exception {
    http.httpBasic();

    // http.authorizeRequests().anyRequest().authenticated(); // by default all request are authenticated
    // http.authorizeRequests().anyRequest().permitAll(); // all request are permitted

/*    http.authorizeRequests()
        .antMatchers(HttpMethod.GET).access("hasAnyRole('ROLE_ADMIN')")
        .antMatchers(HttpMethod.POST).access("hasAnyRole('ROLE_MANAGER')")
        .anyRequest().permitAll();*/

    http.authorizeRequests()
//        .antMatchers(HttpMethod.GET, "/hello").access("hasRole('ADMIN')")
        .antMatchers(HttpMethod.GET, "/hello").hasRole("ADMIN")
        .anyRequest().permitAll();
  }

}
