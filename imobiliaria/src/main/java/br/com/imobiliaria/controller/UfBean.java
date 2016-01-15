package br.com.imobiliaria.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.imobiliaria.model.Uf;
import br.com.imobiliaria.repository.UfRepository;
import br.com.imobiliaria.util.jsf.JsfUtil;

@Named
@ViewScoped
public class UfBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Uf uf;
	private List<Uf> lista;
	private List<Uf> listaFiltrada;
	
	@Inject
	private UfRepository ufs;


	public Uf getUf() {
		return uf;
	}

	public void setUf(Uf uf) {
		this.uf = uf;
	}

	public List<Uf> getLista() {
		return lista;
	}

	public void setLista(List<Uf> lista) {
		this.lista = lista;
	}

	public List<Uf> getListaFiltrada() {
		return listaFiltrada;
	}

	public void setListaFiltrada(List<Uf> listaFiltrada) {
		this.listaFiltrada = listaFiltrada;
	}

	@PostConstruct
	public void init() {
		uf = new Uf();
		atualizarLista();
	}

	private void atualizarLista() {
		try {
			lista = ufs.todos();
		} catch (Exception e) {
			JsfUtil.adicionarGrowlErro("Ocorreu um erro ao listar os UFs.");
		}
	}

	public void novo() {
		uf = new Uf();
	}
	
	public void salvar() {
		try {
			ufs.adicionar(uf);

			atualizarLista();

			JsfUtil.adicionarGrowlInfo("UF adicionado com sucesso.");
		} catch (Exception e) {
			JsfUtil.adicionarMensagemErro("Ocorreu um erro ao salvar o UF.");
			e.printStackTrace();
		}
	}

	public void editar() {
		try {
			ufs.atualizar(uf);

			atualizarLista();

			JsfUtil.adicionarGrowlInfo("UF editado com sucesso.");
		} catch (Exception e) {
			JsfUtil.adicionarMensagemErro("Ocorreu um erro ao editar o UF.");
			e.printStackTrace();
		}
	}

	public void excluir() {
		try {
			ufs.remover(uf);

			atualizarLista();

			JsfUtil.adicionarGrowlInfo("UF excluido com sucesso.");
		} catch (Exception e) {
			JsfUtil.adicionarMensagemErro("Ocorreu um erro ao excluir o UF.");
			e.printStackTrace();
		}
	}

}
