package br.com.imobiliaria.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.imobiliaria.model.Cidade;
import br.com.imobiliaria.util.jpa.Transactional;

public class CidadeRepository implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public List<Cidade> todos() {
		return manager.createQuery("from Cidade c inner join fetch c.uf order by c.id", Cidade.class).getResultList();
	}
	
	public Cidade porId(Long id) {
		return manager.find(Cidade.class, id);
	}
	
	@Transactional
	public void adicionar(Cidade cidade) {
		manager.persist(cidade);
	}
	
	@Transactional
	public void atualizar(Cidade cidade) {
		manager.merge(cidade);
	}
	
	@Transactional
	public void remover(Cidade cidade) {
		Cidade c = porId(cidade.getId());
		manager.remove(c);
	}
	
}
