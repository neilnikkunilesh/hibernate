package in.cdac.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class AttendanceLookupSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		// add out users for in memory authentication

		UserBuilder users = User.withDefaultPasswordEncoder();

		auth.inMemoryAuthentication().withUser(users.username("cdacexam").password("Cdacexam@123").roles("ADMIN"))
				.withUser(users.username("iafexam").password("Iafexam@123").roles("USER"));

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		System.out.println("Inside HttpSecurity");
		http.authorizeRequests().antMatchers("/resources/**").permitAll()
		.anyRequest().authenticated()
		.and()
		.formLogin()
		.loginPage("/showMyLoginPage")
		.loginProcessingUrl("/authenticateTheUser")
		.permitAll()
		.and()
		.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
		
		 /* http.authorizeRequests().antMatchers("/index","/").permitAll()
		 * .antMatchers("/user").hasRole("USER")
		 * .and().formLogin().loginPage("/loginpage") .loginProcessingUrl("/loginform")
		 * .permitAll();
		 */
	}
	
	/*@Override
	public void configure(WebSecurity web) throws Exception {
		System.out.println("Inside WebSecurity");
		web
		.ignoring()
		.antMatchers("/resources/**");
		
		  http.authorizeRequests().antMatchers("/index","/").permitAll()
		 * .antMatchers("/user").hasRole("USER")
		 * .and().formLogin().loginPage("/loginpage") .loginProcessingUrl("/loginform")
		 * .permitAll();
		 
	}*/
}
