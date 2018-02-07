package com.config;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	{
		System.out.println("SecurityConfig start ------------");
	}
	
	@Override
	public void configure(WebSecurity web) {
		System.out.println("SecurityConfig start ----WebSecurity--------");
		ArrayList<String> patterns = new ArrayList<String>();
		//patterns.add("/**/aaa");
		web.ignoring().antMatchers(patterns.toArray(new String[0]));
	}
	
	
	@Override
	final protected void configure(HttpSecurity http) throws Exception {
		System.out.println("SecurityConfig start ----HttpSecurity--------");
		/*http.authorizeRequests().antMatchers("/login").anonymous();//指定登录界面容许匿名登录   
		http.authorizeRequests() .anyRequest().authenticated()   
		//容许嵌入框架iframe  
		.and().headers().frameOptions().disable() .and() .httpBasic()  
		//defaultSuccessUrl:指定登录成功后界面, loginPage:指定登录界面  
		.and().formLogin().defaultSuccessUrl("/main.to").loginPage("/login") .permitAll();  */
		
		/*http
        .authorizeRequests()
            .antMatchers("/resources/**").permitAll() 
            .anyRequest().authenticated()
            .and();*/
		//http.antMatcher("/**");
		
		http
        .authorizeRequests()
            .antMatchers("/", "/home").permitAll()
            .anyRequest().authenticated()
            .and()
        .formLogin()
            .loginPage("/login")
            .defaultSuccessUrl("/helloadmin")
            .permitAll()
            .and()
        .logout()
            .permitAll();

	}
    public DefaultWebSecurityExpressionHandler webSecurityExpressionHandler() {  
        DefaultWebSecurityExpressionHandler webSecurityExpressionHandler = new DefaultWebSecurityExpressionHandler();  
        return webSecurityExpressionHandler;  
    }
	
    @Override  
    protected void configure(AuthenticationManagerBuilder auth)  
            throws Exception {  
    	System.out.println("SecurityConfig start ----AuthenticationManagerBuilder--------");
        auth.userDetailsService(userDetailsService());  
    } 
    
	@Override
	protected UserDetailsService userDetailsService() {
		return new UserDetailsService(){

			public UserDetails loadUserByUsername(String username)
					throws UsernameNotFoundException {
				// TODO Auto-generated method stub
				ArrayList<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();  
		        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));  
		        if(username.compareTo("lipore")==0){  
		            return new User(username,"123456",authorities);  
		        }else if(username.compareTo("admin")==0){  
		            authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));  
		            return new User(username,"123456",authorities);  
		        }  
		        return null;
			}
			
		};
	}
	
	@Autowired
  public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
      auth
          .inMemoryAuthentication()
              .withUser("admin").password("admin").roles("USER");
  }
}
