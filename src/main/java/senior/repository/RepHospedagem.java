package senior.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import senior.model.Hospedagem;
import senior.model.Hospede;

@RepositoryRestResource(collectionResourceRel = "hospedagem", path = "hospedagem")
public interface RepHospedagem extends PagingAndSortingRepository<Hospedagem, Integer> {

	@Query(value = "select h.hospede from Hospedagem h where h.checkOut = ?1")
	List<Hospede> findByCheckOut(@Param("checkOut") Boolean checkOut);

}
