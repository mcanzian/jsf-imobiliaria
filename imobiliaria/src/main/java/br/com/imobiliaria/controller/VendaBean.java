package br.com.imobiliaria.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.imobiliaria.model.Imovel;
import br.com.imobiliaria.model.Venda;
import br.com.imobiliaria.repository.ImovelRepository;
import br.com.imobiliaria.repository.VendaRepository;
import br.com.imobiliaria.util.jsf.JsfUtil;

@Named
@ViewScoped
public class VendaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Venda venda;
	private List<Venda> lista;
	private List<Venda> listaFiltrada;

	@Inject
	private VendaRepository vendas;

	@Inject
	private ImovelRepository imoveis;

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	public List<Venda> getLista() {
		return lista;
	}

	public void setLista(List<Venda> lista) {
		this.lista = lista;
	}

	public List<Venda> getListaFiltrada() {
		return listaFiltrada;
	}

	public void setListaFiltrada(List<Venda> listaFiltrada) {
		this.listaFiltrada = listaFiltrada;
	}

	@PostConstruct
	public void init() {
		venda = new Venda();
		atualizarLista();
	}

	private void atualizarLista() {
		try {
			lista = vendas.todos();
		} catch (Exception e) {
			JsfUtil.adicionarMensagemErro(e.getMessage());
		}
	}

	public void novo() {
		venda = new Venda();
	}

	public void salvar() {
		try {
			vendas.adicionar(venda);

			atualizarLista();

			JsfUtil.adicionarGrowlInfo("Venda adicionada com sucesso.");
		} catch (Exception e) {
			JsfUtil.adicionarGrowlErro(e.getMessage());
		}
	}

	public void editar() {
		try {
			vendas.atualizar(venda);
			
			atualizarLista();
			
			JsfUtil.adicionarGrowlInfo("Venda editada com sucesso.");
		} catch (Exception e) {
			JsfUtil.adicionarGrowlErro(e.getMessage());
		}
	}

	public void excluir() {
		try {
			vendas.remover(venda);
			
			atualizarLista();
			
			JsfUtil.adicionarGrowlInfo("Venda excluida com sucesso.");
		} catch (Exception e) {
			JsfUtil.adicionarGrowlErro(e.getMessage());
		}
	}
	
	public List<Imovel> todosImoveis() {
		return imoveis.todos();
	}


}
