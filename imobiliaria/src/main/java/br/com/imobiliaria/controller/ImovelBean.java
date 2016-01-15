package br.com.imobiliaria.controller;

import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.io.FilenameUtils;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import br.com.imobiliaria.model.Bairro;
import br.com.imobiliaria.model.Cidade;
import br.com.imobiliaria.model.Foto;
import br.com.imobiliaria.model.Imovel;
import br.com.imobiliaria.model.TipoImovel;
import br.com.imobiliaria.repository.BairroRepository;
import br.com.imobiliaria.repository.CidadeRepository;
import br.com.imobiliaria.repository.ImovelRepository;
import br.com.imobiliaria.util.jsf.JsfUtil;

@Named
@ViewScoped
public class ImovelBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Imovel imovel;
	private List<Imovel> lista;
	private List<Imovel> listaFiltrada;
	private List<Bairro> listaBairros;
	private List<Foto> uploadedFotos;
	

	@Inject
	private Cidade cidade;
	@Inject
	private ImovelRepository imoveis;
	@Inject
	private CidadeRepository cidades;
	@Inject
	private BairroRepository bairros;

	public Imovel getImovel() {
		return imovel;
	}

	public void setImovel(Imovel imovel) {
		this.imovel = imovel;
	}

	public List<Imovel> getLista() {
		return lista;
	}

	public void setLista(List<Imovel> lista) {
		this.lista = lista;
	}

	public List<Imovel> getListaFiltrada() {
		return listaFiltrada;
	}

	public void setListaFiltrada(List<Imovel> listaFiltrada) {
		this.listaFiltrada = listaFiltrada;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public List<Bairro> getListaBairros() {
		return listaBairros;
	}

	public void setListaBairros(List<Bairro> listaBairros) {
		this.listaBairros = listaBairros;
	}

	@PostConstruct
	public void init() {
		imovel = new Imovel();
		listaBairros = new ArrayList<>();
		limparAnexos();
		atualizarLista();
	}

	private void atualizarLista() {
		try {
			lista = imoveis.todos();
		} catch (Exception e) {
			JsfUtil.adicionarMensagemErro("Ocorreu um erro ao listar os imóveis.");
			e.printStackTrace();
		}
	}

	public void novo() {
		imovel = new Imovel();
		listaBairros = new ArrayList<>();
		limparAnexos();
	}

	public void salvar() {
		try {
			imovel.setFotos(uploadedFotos);

			imoveis.adicionar(imovel);

			atualizarLista();

			JsfUtil.adicionarGrowlInfo("Imovel adicionado com sucesso.");
		} catch (Exception e) {
			JsfUtil.adicionarGrowlErro("Ocorreu um erro ao salvar o imóvel.");
			e.printStackTrace();
		}
	}

	public void excluir() {
		try {
			imoveis.remover(imovel);

			atualizarLista();

			JsfUtil.adicionarGrowlInfo("Imovel excluido com sucesso.");
		} catch (Exception e) {
			JsfUtil.adicionarGrowlErro("Ocorreu um erro ao excluir o imóvel.");
			e.printStackTrace();
		}
	}

	public List<TipoImovel> todosTiposImoveis() {
		TipoImovel[] tipos = TipoImovel.values();
		List<TipoImovel> listaTipos = new ArrayList<>();

		for (TipoImovel tipo : tipos) {
			listaTipos.add(tipo);
		}

		return listaTipos;
	}

	public List<Cidade> todasCidades() {
		return cidades.todos();
	}

	public void carregarBairros() {
		listaBairros = bairros.porCidade(cidade);
	}

	public void limparAnexos() {
		uploadedFotos = new ArrayList<>();
	}

	public void uploadFotos(FileUploadEvent event) {
		try {
			UploadedFile uploadedFile = event.getFile();
			String nome = Long.toString(System.currentTimeMillis());
			String extensao = "."+FilenameUtils.getExtension(uploadedFile.getFileName());
			
			Path temp = Files.createTempFile(nome, extensao);
			Files.copy(uploadedFile.getInputstream(), temp, StandardCopyOption.REPLACE_EXISTING);

			Foto foto = new Foto();
			foto.setNome(temp.getFileName().toString());
			foto.setArquivo(temp.toFile());
			
			uploadedFotos.add(foto);
		} catch (IOException e) {
			JsfUtil.adicionarGrowlErro("Ocorreu um erro durante o upload das fotos.");
			e.printStackTrace();
		}
	}

	public int quantidadeAnexos() {
		return uploadedFotos.size();
	}

}