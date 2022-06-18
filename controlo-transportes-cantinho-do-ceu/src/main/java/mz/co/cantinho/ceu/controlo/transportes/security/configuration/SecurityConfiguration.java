package mz.co.cantinho.ceu.controlo.transportes.security.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserPrincipalDetailService uPrincipalDetailService;
	
	@Autowired
	private CustomAuthenticationSuccessHandler successHand;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) {
		auth.authenticationProvider(authenticationProvider());
	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
			.antMatchers("/funcionario/**").hasRole("Administrador")
			.antMatchers("/funcionarios/**").hasRole("Administrador")
			.antMatchers("/carrinhas/**").hasAnyRole("Gestor de transportes", "Administrador")
			.antMatchers("/encarregados/**").hasAnyRole("Secretária", "Administrador")
			.antMatchers("/rota/**").hasAnyRole("Administrador", "Gestor de transportes")
			.antMatchers("/carrinha-avaria").hasAnyRole("Administrador", "Gestor de transportes", "Motorista")
			.antMatchers("/home").hasAnyRole("Gestor de transportes", "Motorista", "Educadora", "Secretária")
			.and()
			.formLogin()
			.loginPage("/").permitAll().successHandler(successHand)
			.and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/");
		
	}
	
	@Bean
	DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
		daoAuthenticationProvider.setUserDetailsService(uPrincipalDetailService);
		return daoAuthenticationProvider;
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}
