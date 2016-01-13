package br.com.imobiliaria.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.imobiliaria.model.Bairro;
import br.com.imobiliaria.model.Cidade;
import br.com.imobiliaria.repository.BairroRepository;
import br.com.imobiliaria.repository.CidadeRepository;
import br.com.imobiliaria.util.jsf.JsfUtil;

@Named
@ViewScoped
public class BairroBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Bairro bairro;
	private List<Bairro> lista;
	private List<Bairro> listaFiltrada;
	
	@Inject
	private BairroRepository bairros;
	@Inject
	private CidadeRepository cidades;
	
	
	public Bairro getBairro() {
		return bairro;
	}

	public void setBairro(Bairro bairro) {
		this.bairro = bairro;
	}

	public List<Bairro> getLista() {
		return lista;
	}

	public void setLista(List<Bairro> lista) {
		this.lista = lista;
	}

	public List<Bairro> getListaFiltrada() {
		return listaFiltrada;
	}

	public void setListaFiltrada(List<Bairro> listaFiltrada) {
		this.listaFiltrada = listaFiltrada;
	}

	@PostConstruct
	public void init() {
		bairro = new Bairro();
		atualizarLista();
	}

	private void atualizarLista() {
		try {
			lista = bairros.todos();
		} catch (Exception e) {
			JsfUtil.adicionarMensagemErro(e.getMessage());
		}
	}
	
	public void novo() {
		bairro = new Bairro();
	}
	
	public void salvar() {
		try {
			bairros.adicionar(bairro);
			
			atualizarLista();
			
			JsfUtil.adicionarGrowlAviso("Bairro adicionado com sucesso.");
		} catch (Exception e) {
			JsfUtil.adicionarGrowlErro(e.getMessage());
		}
	}
	
	public void editar() {
		try {
			bairros.atualizar(bairro);
			
			atualizarLista();
			
			JsfUtil.adicionarGrowlInfo("Bairro editado com sucesso.");
		} catch (Exception e) {
			JsfUtil.adicionarGrowlErro(e.getMessage());
		}
	}
	
	public void excluir() {
		try {
			bairros.remover(bairro);
			
			atualizarLista();
			
			JsfUtil.adicionarGrowlInfo("Bairro excluido com sucesso.");
		} catch (Exception e) {
			JsfUtil.adicionarGrowlErro(e.getMessage());
		}
	}
	
	public List<Cidade> todasCidades() {
		return cidades.todos(); 
	}
	
}