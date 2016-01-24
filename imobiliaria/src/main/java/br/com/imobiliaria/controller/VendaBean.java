package br.com.imobiliaria.controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.hibernate.validator.constraints.NotBlank;
import org.omnifaces.util.Faces;
import org.primefaces.component.datatable.DataTable;

import br.com.imobiliaria.model.Imovel;
import br.com.imobiliaria.model.Relatorio;
import br.com.imobiliaria.model.Venda;
import br.com.imobiliaria.repository.ImovelRepository;
import br.com.imobiliaria.repository.VendaRepository;
import br.com.imobiliaria.util.jsf.JsfUtil;
import net.sf.jasperreports.engine.JRException;

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
			JsfUtil.adicionarMensagemErro("Ocorreu um erro ao listar as vendas.");
			e.printStackTrace();
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
			JsfUtil.adicionarGrowlErro("Ocorreu um erro ao salvar a venda.");
			e.printStackTrace();
		}
	}

	public void editar() {
		try {
			vendas.atualizar(venda);

			atualizarLista();

			JsfUtil.adicionarGrowlInfo("Venda editada com sucesso.");
		} catch (Exception e) {
			JsfUtil.adicionarGrowlErro("Ocorreu um erro ao editar a venda.");
			e.printStackTrace();
		}
	}

	public void excluir() {
		try {
			vendas.remover(venda);

			atualizarLista();

			JsfUtil.adicionarGrowlInfo("Venda excluida com sucesso.");
		} catch (Exception e) {
			JsfUtil.adicionarGrowlErro("Ocorreu um erro ao excluir a venda.");
			e.printStackTrace();
		}
	}

	public List<Imovel> todosImoveis() {
		return imoveis.todos();
	}
	
	@NotBlank
	public String getIdImovel() {
		if (venda.getImovel() == null)
			return null;
		
		return venda.getImovel().getId().toString();
	}
	
	public void setIdImovel(String idImovel) {
		//venda.getImovel().setId(new Long(idImovel));
	}

	public void gerarRelatorio() {
		try {
			String caminho = Faces.getRealPath("/relatorios/vendas.jasper");
			Map<String, Object> parametros = prepararFiltrosParaRelatorio();

			Relatorio relatorio = new Relatorio();
			relatorio.gerar(caminho, parametros);

			JsfUtil.adicionarGrowlInfo("Relatório gerado com sucesso.");
		} catch (JRException | IOException e) {
			JsfUtil.adicionarGrowlErro("Ocorreu um erro ao gerar o relatório.");
			e.printStackTrace();
		}
	}

	private Map<String, Object> prepararFiltrosParaRelatorio() {
		DataTable tabela = (DataTable) Faces.getViewRoot().findComponent("formTabelaVenda:tabelaVenda");

		Map<String, Object> filtros = tabela.getFilters();
		Map<String, Object> parametros = new HashMap<>();

		String id = (String) filtros.get("id");
		String valor = (String) filtros.get("valor");
		String imovel = (String) filtros.get("imovel.id");

		if (id == null)
			parametros.put("VENDA_ID", "%%");
		else
			parametros.put("VENDA_ID", id + "%");

		if (valor == null)
			parametros.put("VENDA_VALOR", "%%");
		else
			parametros.put("VENDA_VALOR", valor + "%");

		if (imovel == null)
			parametros.put("VENDA_IMOVEL", "%%");
		else
			parametros.put("VENDA_IMOVEL", imovel + "%");

		return parametros;
	}

}
