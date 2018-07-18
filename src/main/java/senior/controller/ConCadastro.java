package senior.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import senior.model.Hospede;
import senior.repository.RepHospede;

@RestController
public class ConCadastro {

	@Autowired
	RepHospede repCadastro;

	@RequestMapping(path = "/cadastrar", method = RequestMethod.POST)
	public Hospede cadastrarHospede(@RequestBody Hospede hospede) throws Exception {

		if (hospede.getId() == null) {
			if (hospede.getNome() != "") {
				if (hospede.getDocumento() != null) {
					if (hospede.getTelefone() != null) {
						hospede.setTotalGasto(0F);
						hospede.setUltimoValorGasto(0F);

						return repCadastro.save(hospede);
					}
					throw new Exception("Telefone incorreto, Apenas números");
				}
				throw new Exception("Documento incorreto, Apenas números");
			}
			throw new Exception("Faltou informar o Nome.");
		}
		throw new Exception("Esse método e para cadastrar novos hospedes não para alterar o cadastro");
	}

	@RequestMapping(path = "/alterar-cadastro", method = RequestMethod.POST)
	public Hospede alterarCadastro(@RequestBody Hospede hospede) throws Exception {
		Hospede hospedeBanco = repCadastro.findOne(hospede.getId());

		if (hospedeBanco != null) {
			return repCadastro.save(hospede);
		}
		throw new Exception("Hospede ainda não cadastrado");
	}

	@RequestMapping(path = "/busca-cadastro", method = RequestMethod.GET)
	public List<Hospede> buscaCadastro(@RequestParam String nome, @RequestParam Integer documento,
			@RequestParam Integer telefone) throws Exception {

		// Verifica pelo que vai buscar o hospede
		if (nome != "") {
			return repCadastro.findByNome(nome);
		} else if (documento != null) {
			return repCadastro.findByDocumento(documento);
		} else if (telefone != null) {
			return repCadastro.findByTelefone(telefone);
		}
		throw new Exception("Hospede não encontrado");

	}

}
