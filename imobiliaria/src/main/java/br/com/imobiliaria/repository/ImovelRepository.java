package br.com.imobiliaria.repository;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.imobiliaria.model.Foto;
import br.com.imobiliaria.model.Imovel;
import br.com.imobiliaria.util.jpa.Transactional;

public class ImovelRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public List<Imovel> todos() {
		return manager.createQuery(
				"from Imovel i " +
				"inner join fetch i.bairro b " +
				"inner join fetch b.cidade c " +
				"inner join fetch c.uf u " +
				"order by i.id", Imovel.class).getResultList();
	}

	public Imovel porId(Long id) {
		return manager.find(Imovel.class, id);
	}

	@Transactional
	public void adicionar(Imovel imovel) throws IOException {
		manager.persist(imovel);
		manager.flush();

		for (Foto foto : imovel.getFotos()) {
			foto.gravar();
		}
	}

	@Transactional
	public void remover(Imovel imovel) {
		Imovel i = porId(imovel.getId());
		manager.remove(i);
	}

}
