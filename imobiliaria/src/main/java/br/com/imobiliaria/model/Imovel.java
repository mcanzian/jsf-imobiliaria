package br.com.imobiliaria.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "imovel")
public class Imovel implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_imovel", length = 20, nullable = false)
	private TipoImovel tipo;
	
	@Column(nullable = true)
	private Boolean condominio;
	
	@NotNull
	@Column(nullable = false)
	private Integer quartos;
	
	@NotNull
	@Column(nullable = false)
	private Integer banheiros;
	
	@Column(nullable = true)
	private Integer suites;
	
	@Column(nullable = true)
	private Integer garagem;
	
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "bairro_id", nullable = false)
	private Bairro bairro;
	
	@NotNull
	@Column(name = "area_total", nullable = false)
	private Integer areaTotal;
	
	@Column(name = "area_construida", nullable = true)
	private Integer areaConstruida;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "imovel", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Foto> fotos;
	
	@Column(columnDefinition = "text", nullable = true)
	private String comentarios;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TipoImovel getTipo() {
		return tipo;
	}

	public void setTipo(TipoImovel tipo) {
		this.tipo = tipo;
	}

	public Boolean getCondominio() {
		return condominio;
	}

	public void setCondominio(Boolean condominio) {
		this.condominio = condominio;
	}

	public Integer getQuartos() {
		return quartos;
	}

	public void setQuartos(Integer quartos) {
		this.quartos = quartos;
	}

	public Integer getBanheiros() {
		return banheiros;
	}

	public void setBanheiros(Integer banheiros) {
		this.banheiros = banheiros;
	}

	public Integer getSuites() {
		return suites;
	}

	public void setSuites(Integer suites) {
		this.suites = suites;
	}

	public Integer getGaragem() {
		return garagem;
	}

	public void setGaragem(Integer garagem) {
		this.garagem = garagem;
	}

	public Bairro getBairro() {
		return bairro;
	}

	public void setBairro(Bairro bairro) {
		this.bairro = bairro;
	}

	public Integer getAreaTotal() {
		return areaTotal;
	}

	public void setAreaTotal(Integer areaTotal) {
		this.areaTotal = areaTotal;
	}

	public Integer getAreaConstruida() {
		return areaConstruida;
	}

	public void setAreaConstruida(Integer areaConstruida) {
		this.areaConstruida = areaConstruida;
	}

	public List<Foto> getFotos() {
		return fotos;
	}

	public void setFotos(List<Foto> fotos) {
		if (fotos.size() > 5)
			return;

		this.fotos = fotos;

		for (Foto foto : fotos) {
			foto.setImovel(this);
		}
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
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
		Imovel other = (Imovel) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
