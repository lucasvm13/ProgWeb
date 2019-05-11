package br.unisul.web.sexta.config.dtos;

import java.io.Serializable;

import br.unisul.web.sexta.domain.Estado;

public class EstadoDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String uf;

	public EstadoDto(Estado e) {
		id = e.getId();
		uf = e.getUf();
	}

	public EstadoDto() {

	}

	public EstadoDto(Integer id, String uf) {
		this.id = id;
		this.uf = uf;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EstadoDto other = (EstadoDto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
