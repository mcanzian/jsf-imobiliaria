package br.com.imobiliaria.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;

import org.springframework.format.annotation.NumberFormat;

@Entity
@Table(name="locacao")
public class Locacao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="imovel_id", referencedColumnName="id", nullable=false)
	private Imovel imovel;
	
	@DecimalMin(value="0.01")
	@DecimalMax(value="999999999.99")
	@NumberFormat(pattern = "#,##0.00")
	@Column(nullable=false)
	private Double valor;
	
	@DecimalMin(value="0.01")
	@DecimalMax(value="99999.99")
	@NumberFormat(pattern = "#,##0.00")
	@Column(nullable=true)
	private Double condominio;
	
	@DecimalMin(value="0.01")
	@DecimalMax(value="99999.99")
	@NumberFormat(pattern = "#,##0.00")
	@Column(nullable=true)
	private Double taxas;

	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public Imovel getImovel() {
		return imovel;
	}

	public void setImovel(Imovel imovel) {
		this.imovel = imovel;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Double getCondominio() {
		return condominio;
	}

	public void setCondominio(Double condominio) {
		this.condominio = condominio;
	}

	public Double getTaxas() {
		return taxas;
	}

	public void setTaxas(Double taxas) {
		this.taxas = taxas;
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
		Locacao other = (Locacao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
