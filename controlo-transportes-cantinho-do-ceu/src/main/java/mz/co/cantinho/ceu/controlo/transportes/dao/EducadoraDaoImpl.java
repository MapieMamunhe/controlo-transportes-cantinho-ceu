package mz.co.cantinho.ceu.controlo.transportes.dao;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import mz.co.cantinho.ceu.controlo.transportes.domain.Educadora;
import mz.co.cantinho.ceu.controlo.transportes.domain.Funcionario;

@Repository
public class EducadoraDaoImpl extends AbstractDao<Educadora, Long> implements EducadoraDao{

	@Override
	public void save(Funcionario funcionario) {
		callAdicionarEducadora(funcionario.getNome(), funcionario.getApelido(), funcionario.getDataNascimento(),
				funcionario.getSexo(), funcionario.getTipoDocumento(), funcionario.getNrDocumento(),
				funcionario.getTelefone(), funcionario.getTelefoneAlternativo(),
				funcionario.getEmail(), funcionario.getResidencia());
	}
	
	/*@Query(nativeQuery = true, value = "CALL adicionar_motorista(:nome, :apelido, :dataNascimento,"
	+ ":sexo, :tipoDocumento, :nrDocumento, :telefone, :telefoneAlternativo, :email, :residencia)")
void saveMotorista(@Param("nome") String nome, @Param("apelido") String apelido, @Param("dataNascimento")LocalDate dataNascimento,
	@Param("sexo")String sexo, @Param("tipoDocumento")String tipoDocumento, @Param("nrDocumento")String nrDocumento,
	@Param("telefone") String telefone, @Param("telefoneAlternativo") String telefoneAlternativo, @Param("email")String email,
	@Param("residencia")String residencia);*/
	
	@Query(nativeQuery = true, value = "CALL adicionar_educadora(:_nome, :_apelido, :_dataNascimento,"
			+ ":_sexo, :_tipoDocumento, :_nrDocumento, :_telefone, :_telefoneAlternativo, :_email, :_residencia)")
	private void callAdicionarEducadora(@Param("_nome") String nome,
			@Param("_apelido") String apelido,
			@Param("_dataNascimento")LocalDate dataNascimento,
			@Param("_sexo")String sexo,
			@Param("_tipoDocumento")String tipoDocumento,
			@Param("_nrDocumento")String nrDocumento,
			@Param("_telefone") String telefone,
			@Param("_telefoneAlternativo") String telefoneAlternativo,
			@Param("_email")String email,
			@Param("_residencia")String residencia) {
		
		System.out.println("Adicionar funcionario-educadora");
	}

	
}
