	package mz.co.cantinho.ceu.controlo.transportes.security.configuration;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import mz.co.cantinho.ceu.controlo.transportes.domain.ContaFuncionario;

@SuppressWarnings("serial")
public class UserPrincipal implements UserDetails {

	private ContaFuncionario contaFuncionario;
	
	public UserPrincipal(ContaFuncionario contaFuncionario) {
		this.contaFuncionario = contaFuncionario;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Arrays.asList(new SimpleGrantedAuthority(contaFuncionario.getPerfil().getNome()));
	}

	@Override
	public String getPassword() {
		return this.contaFuncionario.getPalavraPasse();
	}

	@Override
	public String getUsername() {
		return this.contaFuncionario.getFuncionario().getNome();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
