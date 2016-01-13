package br.com.imobiliaria.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.imobiliaria.model.Uf;
import br.com.imobiliaria.repository.UfRepository;
import br.com.imobiliaria.util.cdi.CDIServiceLocator;

@FacesConverter(forClass=Uf.class)
public class UfConverter implements Converter {

	private UfRepository ufs;
	
	public UfConverter() {
		ufs = CDIServiceLocator.getBean(UfRepository.class);
	}
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value == null || value.isEmpty())
			return null;
		
		Long id = new Long(value);
		return ufs.porId(id);
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value == null || !(value instanceof Uf) || ((Uf) value).getId() == null)
			return "";
			
		return ((Uf) value).getId().toString();
	}

}
