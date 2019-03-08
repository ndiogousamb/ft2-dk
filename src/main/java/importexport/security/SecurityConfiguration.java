package importexport.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	@Autowired
	DataSource dataSource;

	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		   auth.jdbcAuthentication().dataSource(dataSource)
			  .usersByUsernameQuery(
			   "SELECT login,password,enabled,ur.role FROM `utilisateur` u ,user_roles ur WHERE u.role=ur.user_role_id and u.login=?")
			  .authoritiesByUsernameQuery(
			   "SELECT ur.user_role_id,ur.role FROM `utilisateur` u ,user_roles ur WHERE u.role=ur.user_role_id and u.login=?");
			 } 
			 @Override
			 protected void configure(HttpSecurity http) throws Exception {
			   http.authorizeRequests()
			   .antMatchers("/").access("hasRole('ROLE_ADMIN') OR hasRole('ROLE_UTLISATEUR')")
			   .antMatchers("/accueil").access("hasRole('ROLE_ADMIN') OR hasRole('ROLE_UTLISATEUR')")
			   .antMatchers("/administration").access("hasRole('ROLE_ADMIN')") 
			   // .access("hasRole('ROLE_ADMIN') OR hasRole('ROLE_USER')")
			 // .antMatchers("/compte/**").access("hasRole('ROLE_ADMIN')") 
			//  .antMatchers("/transaction/**").access("hasRole('ROLE_ADMIN')")
			   .antMatchers("/user/sincrire").access("hasRole('ROLE_ADMIN') OR hasRole('ROLE_UTLISATEUR') OR hasRole('ROLE_ANONYMOUS')")
			  .anyRequest().permitAll()
			  .and()
			    .formLogin().loginPage("/user/login").failureUrl("/user/login?error")
			    .usernameParameter("username").passwordParameter("password")
			  .and()
			    .logout().logoutSuccessUrl("/user/login?logout") 
			   .and()
			   .exceptionHandling().accessDeniedPage("/user/403")
			  .and()
			    .csrf();
			 }
}
