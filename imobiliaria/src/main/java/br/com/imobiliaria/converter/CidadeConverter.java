package br.com.imobiliaria.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.imobiliaria.model.Cidade;
import br.com.imobiliaria.repository.CidadeRepository;
import br.com.imobiliaria.util.cdi.CDIServiceLocator;

@FacesConverter(forClass=Cidade.class)
public class CidadeConverter implements Converter {

	private CidadeRepository cidades;
	
	public CidadeConverter() {
		cidades = CDIServiceLocator.getBean(CidadeRepository.class);
	}
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value == null || value.isEmpty())
			return null;
		
		Long id = new Long(value); 
		return cidades.porId(id);
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value == null || !(value instanceof Cidade) || ((Cidade) value).getId() == null)
			return "";
		
		return ((Cidade) value).getId().toString();
	}

}
