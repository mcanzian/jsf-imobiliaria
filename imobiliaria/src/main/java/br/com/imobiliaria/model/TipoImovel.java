package br.com.imobiliaria.model;

public enum TipoImovel {
	APARTAMENTO("Apartamento"),
	CASA("Casa"),
	JK("JK"),
	TERRENO("Terreno");
	
	private String descricao;
	
	private TipoImovel(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}