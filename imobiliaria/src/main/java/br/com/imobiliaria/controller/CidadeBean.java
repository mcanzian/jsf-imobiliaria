package br.com.imobiliaria.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.imobiliaria.model.Cidade;
import br.com.imobiliaria.model.Uf;
import br.com.imobiliaria.repository.CidadeRepository;
import br.com.imobiliaria.repository.UfRepository;
import br.com.imobiliaria.util.jsf.JsfUtil;

@Named
@ViewScoped
public class CidadeBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Cidade cidade;
	private List<Cidade> lista;
	private List<Cidade> listaFiltrada;
	
	@Inject
	private CidadeRepository cidades;
	@Inject
	private UfRepository ufs;
	
	
	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public List<Cidade> getLista() {
		return lista;
	}

	public void setLista(List<Cidade> lista) {
		this.lista = lista;
	}

	public List<Cidade> getListaFiltrada() {
		return listaFiltrada;
	}

	public void setListaFiltrada(List<Cidade> listaFiltrada) {
		this.listaFiltrada = listaFiltrada;
	}

	@PostConstruct
	public void init() {
		cidade = new Cidade();
		atualizarLista();
	}
	
	private void atualizarLista() {
		try {
			lista = cidades.todos();
		} catch (Exception e) {
			JsfUtil.adicionarGrowlErro("Ocorreu um erro ao listar as cidades.");
			e.printStackTrace();
		}
	}
	
	public void novo() {
		cidade = new Cidade();
	}
	
	public void salvar() {
		try {
			cidades.adicionar(cidade);
			
			atualizarLista();
			
			JsfUtil.adicionarGrowlInfo("Cidade adicionada com sucesso.");
		} catch (Exception e) {
			JsfUtil.adicionarGrowlErro("Ocorreu um erro ao salvar a cidade.");
			e.printStackTrace();
		}
	}
	
	public void editar() {
		try {
			cidades.atualizar(cidade);
			
			atualizarLista();
			
			JsfUtil.adicionarGrowlInfo("Cidade editada com sucesso.");
		} catch (Exception e) {
			JsfUtil.adicionarGrowlErro("Ocorreu um erro ao editar a cidade.");
			e.printStackTrace();
		}
	}
	
	public void excluir() {
		try {
			cidades.remover(cidade);
			
			atualizarLista();
			
			JsfUtil.adicionarGrowlInfo("Cidade excluida com sucesso.");
		} catch (Exception e) {
			JsfUtil.adicionarGrowlErro("Ocorreu um erro ao excluir a cidade.");
			e.printStackTrace();
		}
	}
	
	public List<Uf> todosUfs() {
		return ufs.todos();
	}
	
}
