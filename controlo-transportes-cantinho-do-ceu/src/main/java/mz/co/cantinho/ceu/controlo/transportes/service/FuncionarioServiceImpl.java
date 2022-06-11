package mz.co.cantinho.ceu.controlo.transportes.service;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mz.co.cantinho.ceu.controlo.transportes.dao.FuncionarioDao;
import mz.co.cantinho.ceu.controlo.transportes.domain.Educadora;
import mz.co.cantinho.ceu.controlo.transportes.domain.Funcionario;
import mz.co.cantinho.ceu.controlo.transportes.domain.Motorista;
import mz.co.cantinho.ceu.controlo.transportes.domain.Residencia;

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
	ZonaService zonaService;
	
	@Autowired
	ResidenciaService residenciaService;
	
	@Override
	public void gravar(Funcionario funcionario) {
		dao.save(funcionario);
		registarResidencia(funcionario);
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
		return sort(dao.findAll());
	}

	@Override
	@Transactional(readOnly = true)
	public boolean celularExiste(String telefone, Long id) {
		return dao.celularExiste(telefone, id);
	}

	@Override
	@Transactional(readOnly = true)
	public boolean emailExiste(String email, Long id) {
		return dao.emailExiste(email, id);
	}
	
	@Override
	public List<Funcionario> buscarPorNome(String nome) {
		return sort(dao.findByName(nome));
	}
	
	@Override
	@Transactional(readOnly = true)
	public boolean nrDocumentoExiste(String nrDocumento, Long id) {
		return dao.nrDocumentoExiste(nrDocumento, id);
	}
	
	//========================================AUXILIARES===========================================
	
	// Regista funcionário de acordo com o papel (mototrista ou educadora)
		private void registarPorPapel(Funcionario funcionario) {
			switch (funcionario.getConta().getPerfil().getNome()) {
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
		
		//Armazenar residência de funcionário
		private void registarResidencia(Funcionario funcionario) {
			Residencia residencia = new Residencia();
			residencia.setQuarteirao(funcionario.getResidenciaQuarteirao());
			residencia.setFuncionario(funcionario);
			residencia.setZona(zonaService.buscarPorNome(funcionario.getResidencia()));
			residenciaService.gravar(residencia);
		}
		
		//Colocar residência em cada funcionário
		private void funcionarioResidencia(List<Funcionario> funcionario) {
			Funcionario actual;
			for(int i = 0; i < funcionario.size(); i++) {
				actual = funcionario.get(i);
				Residencia residencia = residenciaDe(actual);
				actual.setResidencia(residencia.getZona().getNome() + ", " + residencia.getZona().getCidade());
				actual.setResidenciaQuarteirao(residencia.getQuarteirao());
				
			}
		}
		
		//Encontrar residência de cada funcionário
		private Residencia residenciaDe(Funcionario funcionario) {
			return residenciaService.buscarPorFuncionario(funcionario);
		}
		
		private List<Funcionario> sort(List<Funcionario> funcionarios) {
			funcionarios.sort(Comparator.comparing(Funcionario::getNome).thenComparing(Funcionario::getApelido));
			funcionarioResidencia(funcionarios);
			return funcionarios;
		}

}
