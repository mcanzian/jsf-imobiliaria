package br.com.imobiliaria.repository.test;

import java.util.List;

import org.junit.Test;

import br.com.imobiliaria.model.Uf;
import br.com.imobiliaria.repository.UfRepository;

public class UfRepositoryTest {

	@Test
	public void listarUfsDoBanco() throws Exception {
		UfRepository ufs = new UfRepository();
		List<Uf> lista = ufs.todos();
		
		System.out.println(lista.size());
	}
	
}
