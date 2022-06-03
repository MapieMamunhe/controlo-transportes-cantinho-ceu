package mz.co.cantinho.ceu.controlo.transportes.security.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import mz.co.cantinho.ceu.controlo.transportes.dao.ContaFuncionarioDao;
import mz.co.cantinho.ceu.controlo.transportes.dao.FuncionarioDao;
import mz.co.cantinho.ceu.controlo.transportes.domain.ContaFuncionario;

@Service
public class UserPrincipalDetailService implements UserDetailsService {

	@Autowired
	private FuncionarioDao funcionarioDao;
	
	@Autowired
	private ContaFuncionarioDao contaFuncionarioDao;
	
	//elimnar
	public PasswordEncoder pass() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		ContaFuncionario conta = contaFuncionarioDao.findByFuncionarioId(funcionarioDao.findByCellOrEmail(username).getId());
		//eliminar pass.encode
		conta.setPalavraPasse(pass().encode(conta.getPalavraPasse()));
		conta.getPerfil().setNome("ROLE_"+conta.getPerfil().getNome());
		UserPrincipal userPrincipal = new UserPrincipal(conta);
		
		return userPrincipal;
	}

}
