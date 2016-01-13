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

@Entity
@Table(name="venda")
public class Venda implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Imovel imovel;
	private Double valor;

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="imovel_id", referencedColumnName="id", nullable=false)
	public Imovel getImovel() {
		return imovel;
	}

	public void setImovel(Imovel imovel) {
		this.imovel = imovel;
	}
	
	@Column(precision=10, scale=2, nullable=false)
	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
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
		Venda other = (Venda) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		String obj = "\n\n";
		obj += "Id: "+id+"\n";
		obj += "Imovel: "+imovel.getId()+"\n";
		obj += "Valor: "+valor+"\n\n";
		return obj;
	}
	
}
