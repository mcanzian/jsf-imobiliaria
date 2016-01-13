package br.com.imobiliaria.model;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.imobiliaria.util.jsf.JsfUtil;

@Entity
@Table(name = "foto")
public class Foto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;
	private Imovel imovel;
	private File arquivo;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Size(min = 1, max = 100)
	@Column(length = 100, nullable = false)
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@NotNull
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "imovel_id", nullable = false)
	public Imovel getImovel() {
		return imovel;
	}

	public void setImovel(Imovel imovel) {
		this.imovel = imovel;
	}

	@Transient
	public File getArquivo() {
		if (arquivo == null)
			return new File(diretorioDeGravacao() + nome);
		
		return arquivo;
	}

	public void setArquivo(File arquivo) {
		this.arquivo = arquivo;
	}

	@Transient
	public String getUrl() throws IOException {
		return JsfUtil.urlUpload() + imovel.getId() + "/" + nome;
	}

	public void gravar() throws IOException {
		Files.createDirectories(Paths.get(diretorioDeGravacao()));

		File origem = arquivo;
		File destino = new File(diretorioDeGravacao() + nome);

		com.google.common.io.Files.copy(origem, destino);

		arquivo = destino;
	}

	private String diretorioDeGravacao() {
		return JsfUtil.diretorioUpload() + imovel.getId() + File.separator;
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
		Foto other = (Foto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
