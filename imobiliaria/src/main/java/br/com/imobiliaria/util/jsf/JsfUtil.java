package br.com.imobiliaria.util.jsf;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

public class JsfUtil {

	public static void adicionarMensagemInfo(String mensagem) {
		FacesContext contexto = FacesContext.getCurrentInstance();
		contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, mensagem, mensagem));
	}
	
	public static void adicionarMensagemErro(String mensagem) {
		FacesContext contexto = FacesContext.getCurrentInstance();
		contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, mensagem, mensagem));
	}
	
	public static void adicionarMensagemAviso(String mensagem) {
		FacesContext contexto = FacesContext.getCurrentInstance();
		contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, mensagem, mensagem));
	}

	public static void adicionarGrowlInfo(String mensagem) {
		FacesContext contexto = FacesContext.getCurrentInstance();
		contexto.addMessage("growl", new FacesMessage(FacesMessage.SEVERITY_INFO, mensagem, mensagem));
	}
	
	public static void adicionarGrowlErro(String mensagem) {
		FacesContext contexto = FacesContext.getCurrentInstance();
		contexto.addMessage("growl", new FacesMessage(FacesMessage.SEVERITY_ERROR, mensagem, mensagem));
	}
	
	public static void adicionarGrowlAviso(String mensagem) {
		FacesContext contexto = FacesContext.getCurrentInstance();
		contexto.addMessage("growl", new FacesMessage(FacesMessage.SEVERITY_WARN, mensagem, mensagem));
	}
	
	public static String caminhoRaiz() {
		ServletContext context = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();  
		return context.getRealPath("/");
	}
	
	public static String urlUpload() {
		HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		String context = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
		
		return context+"/image/";
	}
	
	public static String diretorioUpload() {
		return "/var/webapps/imobiliaria/upload/";
	}
}
