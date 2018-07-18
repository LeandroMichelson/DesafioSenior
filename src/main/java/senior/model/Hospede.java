package senior.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "hospede", uniqueConstraints = { @UniqueConstraint(columnNames = "documento") })
public class Hospede {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Integer id;

	@NotNull
	private String nome;

	@NotNull
	private Integer documento;

	@NotNull
	private Integer telefone;

	@NotNull
	private Float totalGasto;

	@NotNull
	private Float ultimoValorGasto;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getDocumento() {
		return documento;
	}

	public void setDocumento(Integer documento) {
		this.documento = documento;
	}

	public Integer getTelefone() {
		return telefone;
	}

	public void setTelefone(Integer telefone) {
		this.telefone = telefone;
	}

	public Float getTotalGasto() {
		return totalGasto;
	}

	public void setTotalGasto(Float totalGasto) {
		this.totalGasto = totalGasto;
	}

	public Float getUltimoValorGasto() {
		return ultimoValorGasto;
	}

	public void setUltimoValorGasto(Float ultimoValorGasto) {
		this.ultimoValorGasto = ultimoValorGasto;
	}

}
