package br.com.imobiliaria.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.imobiliaria.model.Bairro;
import br.com.imobiliaria.model.Cidade;
import br.com.imobiliaria.util.jpa.Transactional;

public class BairroRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public List<Bairro> todos() {
		return manager.createQuery("from Bairro b inner join fetch b.cidade order by b.id", Bairro.class)
				.getResultList();
	}

	public Bairro porId(Long id) {
		return manager.find(Bairro.class, id);
	}

	@Transactional
	public void adicionar(Bairro bairro) {
		manager.persist(bairro);
	}

	@Transactional
	public void atualizar(Bairro bairro) {
		manager.merge(bairro);
	}

	@Transactional
	public void remover(Bairro bairro) {
		Bairro b = porId(bairro.getId());
		manager.remove(b);
	}

	public List<Bairro> porCidade(Cidade cidade) {
		return manager.createQuery("from Bairro b inner join fetch b.cidade where b.cidade=:cidade", Bairro.class)
				.setParameter("cidade", cidade).getResultList();
	}
}
