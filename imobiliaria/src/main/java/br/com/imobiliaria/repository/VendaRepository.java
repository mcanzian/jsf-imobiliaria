package br.com.imobiliaria.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.imobiliaria.model.Venda;
import br.com.imobiliaria.util.jpa.Transactional;

public class VendaRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public List<Venda> todos() {
		return manager.createQuery("from Venda v inner join fetch v.imovel order by v.id", Venda.class).getResultList();
	}

	public Venda porId(Long id) {
		return manager.find(Venda.class, id);
	}

	@Transactional
	public void adicionar(Venda venda) {
		manager.persist(venda);
	}

	@Transactional
	public void atualizar(Venda venda) {
		manager.merge(venda);
	}

	@Transactional
	public void remover(Venda venda) {
		Venda v = porId(venda.getId());
		manager.remove(v);
	}

}
