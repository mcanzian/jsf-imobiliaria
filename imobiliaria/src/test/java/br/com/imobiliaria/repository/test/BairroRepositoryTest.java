package br.com.imobiliaria.repository.test;

import java.util.List;

import org.junit.Test;

import br.com.imobiliaria.model.Bairro;
import br.com.imobiliaria.model.Cidade;
import br.com.imobiliaria.repository.BairroRepository;
import br.com.imobiliaria.repository.CidadeRepository;

public class BairroRepositoryTest {

	@Test
	public void listarBairrosPorCidade() throws Exception {
		CidadeRepository cidades = new CidadeRepository();
		Cidade cidade = cidades.porId(21L);
		
		BairroRepository bairros = new BairroRepository();
		List<Bairro> lista = bairros.porCidade(cidade);
		
		for (Bairro bairro : lista) {
			System.out.println(bairro.getNome());
		}
	}
	
}
