package br.com.imobiliaria.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.imobiliaria.model.Uf;
import br.com.imobiliaria.util.jpa.Transactional;

public class UfRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;
	
	
	public List<Uf> todos() {
		return manager.createQuery("from Uf u order by u.id", Uf.class).getResultList();
	}
	
	public Uf porId(Long id) {
		return manager.find(Uf.class, id);
	}

	@Transactional
	public void adicionar(Uf uf) {
		manager.persist(uf);
	}
	
	@Transactional
	public void atualizar(Uf uf) {
		manager.merge(uf);
	}
	
	@Transactional
	public void remover(Uf uf) {
		Uf u = porId(uf.getId());
		manager.remove(u);
	}
}
