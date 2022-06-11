package mz.co.cantinho.ceu.controlo.transportes.security.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
	
<<<<<<< HEAD
	
	
	
=======
>>>>>>> 426f362875632b04420ee5ede9ae0b1dfacc49c4
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		ContaFuncionario conta = contaFuncionarioDao.findByFuncionarioId(funcionarioDao.findByCellOrEmail(username).getId());
		conta.setPalavraPasse(conta.getPalavraPasse());
		conta.getPerfil().setNome("ROLE_"+conta.getPerfil().getNome());
		UserPrincipal userPrincipal = new UserPrincipal(conta);
		
		return userPrincipal;
	}

}
