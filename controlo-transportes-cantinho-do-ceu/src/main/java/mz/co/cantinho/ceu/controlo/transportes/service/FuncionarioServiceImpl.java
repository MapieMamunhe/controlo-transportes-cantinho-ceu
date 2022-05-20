package mz.co.cantinho.ceu.controlo.transportes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mz.co.cantinho.ceu.controlo.transportes.dao.FuncionarioDao;
import mz.co.cantinho.ceu.controlo.transportes.domain.ContaFuncionario;
import mz.co.cantinho.ceu.controlo.transportes.domain.Educadora;
import mz.co.cantinho.ceu.controlo.transportes.domain.Funcionario;
import mz.co.cantinho.ceu.controlo.transportes.domain.Motorista;

@Service
@Transactional(readOnly = false)
public class FuncionarioServiceImpl implements FuncionarioService {

	@Autowired
	private FuncionarioDao dao;

	@Autowired
	private MotoristaService motoristaService;
	
	@Autowired
	private EducadoraService educadoraService;
	
	@Autowired
	private PerfilService perfilService;
	
	@Autowired
	private ContaFuncionarioService contaFuncionarioService;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Override
	public void gravar(Funcionario funcionario) {
		dao.save(funcionario);
		criarConta(funcionario);
		registarPorPapel(funcionario);
	}

	@Override
	public void actualizar(Funcionario funcionario) {
		dao.update(funcionario);
		
	}

	@Override
	public void remover(Long id) {
		dao.delete(id);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Funcionario buscarPorId(Long id) {
		return dao.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Funcionario> buscarTodos() {
		return dao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public boolean nrDocumentoExiste(String nrDocumento) {
		return dao.nrDocumentoExiste(nrDocumento);
	}

	@Override
	@Transactional(readOnly = true)
	public boolean celularExiste(String telefone) {
		return dao.celularExiste(telefone);
	}

	@Override
	@Transactional(readOnly = true)
	public boolean emailExiste(String email) {
		return dao.emailExiste(email);
	}
	
	//=============AUXILIARES==================
	
	// Regista funcionário de acordo com o papel (mototrista ou educadora)
		private void registarPorPapel(Funcionario funcionario) {
			switch (funcionario.getPapel()) {
				case "Motorista":
					Motorista motorista = new Motorista();
					motorista.setFuncionario(funcionario);
					motoristaService.gravar(motorista);
					break;

				case "Educadora":
					Educadora educadora = new Educadora();
					educadora.setFuncionario(funcionario);
					educadoraService.gravar(educadora);
					break;

				default:
					break;
			}
		}

		// Cria conta de funcionário.
		private void criarConta(Funcionario funcionario) {
			ContaFuncionario contaF = new ContaFuncionario();
			contaF.setFuncionario(funcionario);
			contaF.setPerfil(perfilService.buscarPorNome(funcionario.getPapel()));
			contaF.setPalavraPasse(passwordEncoder.encode("0000"));
			contaFuncionarioService.gravar(contaF);
		}

}
