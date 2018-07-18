package senior.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import senior.model.Hospede;

@RepositoryRestResource(collectionResourceRel = "hospede", path = "hospede")
public interface RepHospede extends PagingAndSortingRepository<Hospede, Integer> {

	List<Hospede> findByNome(@Param("nome") String nome);

	List<Hospede> findByDocumento(@Param("documento") Integer documento);

	List<Hospede> findByTelefone(@Param("telefone") Integer telefone);

}
