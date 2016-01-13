package br.com.imobiliaria.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.imobiliaria.model.Bairro;
import br.com.imobiliaria.repository.BairroRepository;
import br.com.imobiliaria.util.cdi.CDIServiceLocator;

@FacesConverter(forClass=Bairro.class)
public class BairroConverter implements Converter {

private BairroRepository bairros;
	
	public BairroConverter() {
		bairros = CDIServiceLocator.getBean(BairroRepository.class);
	}
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value == null || value.isEmpty())
			return null;
		
		Long id = new Long(value); 
		return bairros.porId(id);
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value == null || !(value instanceof Bairro) || ((Bairro) value).getId() == null)
			return "";
		
		return ((Bairro) value).getId().toString();
	}
	
}
