package br.com.imobiliaria.repository.test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import br.com.imobiliaria.model.Bairro;
import br.com.imobiliaria.model.Foto;
import br.com.imobiliaria.model.Imovel;
import br.com.imobiliaria.model.TipoImovel;
import br.com.imobiliaria.repository.BairroRepository;
import br.com.imobiliaria.repository.ImovelRepository;

public class ImovelRepositoryTest {

	@Test
	public void salvarImovelNoBanco() throws IOException {
		File arquivo = new File("/home/marcelo/Área de Trabalho/teste.png");
		
		Foto foto =  new Foto();
		foto.setArquivo(arquivo);
		List<Foto> fotos = new ArrayList<>();
		fotos.add(foto);
		
		BairroRepository bairros = new BairroRepository();
		Bairro bairro = bairros.porId(7L);
		
		Imovel imovel = new Imovel();
		imovel.setTipo(TipoImovel.APARTAMENTO);
		imovel.setCondominio(true);
		imovel.setQuartos(2);
		imovel.setBanheiros(1);
		imovel.setBairro(bairro);
		imovel.setAreaTotal(60);
		imovel.setFotos(fotos);
		imovel.setComentarios("Teste");
		
		ImovelRepository imoveis = new ImovelRepository();
		imoveis.adicionar(imovel);
	}
	
}
