package br.com.acp.beans.common;


import javax.faces.application.FacesMessage;
import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

public class PaginaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final String USUARIO_SESSAO = "USUARIO_SESSAO";
	public static final String INTERESSADO_SESSAO = "INTERESSADO_SESSAO";
    public static final String URLS_PERMITIDAS = "URLS_PERMITIDAS";
    public static final String OPERACOES_PERMITIDAS = "OPERACOES_PERMITIDAS";

	/**
	 * variaveis para paginacao
	 */
	private String pagina;
	private List<String> paginasView;
	private String linkpag = "/pages";
	private String pagInicio = "1";
	private String pagFinal = "1";

	/*
	 *Data corrente
	 */
	private String dataCorrente;

	/**
	 * Adiciona uma nova mensagem do tipo info.
	 *
	 * @param mensagem
	 */
	public void addInfo(String mensagem) {
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, mensagem,
						"Informação"));
	}

	/**
	 * Adiciona uma nova mensagem do tipo warn.
	 *
	 * @param mensagem
	 */
	public void addWarn(String mensagem) {
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_WARN, mensagem,
						"Atenção"));
	}

	/**
	 * Adiciona um novo atributo na sessão.
	 * 
	 * @param chave
	 * @param valor
	 */
	public void addAtributo(String chave, Object valor) {
		getSession().setAttribute(chave, valor);
	}

	/**
	 * Retorna o valor de um atributo da sessão dado uma chave.
	 * 
	 * @param chave
	 * @return valor do tipo Object
	 */
	public Object getAtributo(String chave) {
		if (getSession() != null)
			return getSession().getAttribute(chave);

		return null;
	}

	/**
	 * Remove o valor de um atributo da sessão.
	 * 
	 * @param chave
	 * @return valor do tipo Object
	 */
	public Object removerAtributo(String chave) {
		Object obj = getSession().getAttribute(chave);
		getSession().removeAttribute(chave);
		return obj;
	}

	/**
	 * Adiciona uma variável no request.
	 * 
	 * @param chave
	 * @param valor
	 */
	public void addRequestParameter(String chave, Object valor) {
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap()
				.put(chave, valor);
	}

	/**
	 * Cria um cookie dado um nome.
	 * 
	 * @param nome
	 * @param valor
	 */
	public void addCookie(String nome, String valor) {
		Cookie cookie = new Cookie(nome, valor);
		cookie.setMaxAge(3600);
		getResponse().addCookie(cookie);
	}

	/**
	 * Retorna um cookie dado um nome.
	 * 
	 * @param nome
	 */
	public String getCookie(String nome) {
		Cookie cookies[] = getRequest().getCookies();
		if (cookies != null && cookies.length > 0)
			for (Cookie cookie : cookies)
				if (nome.equals(cookie.getName()))
					return cookie.getValue();
		return null;
	}

	/**
	 * Retorna uma referência do HttpServletResponse.
	 * 
	 * @return HttpServletResponse
	 */
	protected HttpServletResponse getResponse() {
		return (HttpServletResponse) FacesContext.getCurrentInstance()
				.getExternalContext().getResponse();
	}

	/**
	 * 
	 * @param
	 */
	public void doForward(String redirect) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		NavigationHandler myNav = facesContext.getApplication()
				.getNavigationHandler();
		myNav.handleNavigation(facesContext, null, redirect);
	}

	/**
	 * Retorna uma referência do HttpServletRequest.
	 * 
	 * @return HttpServletRequest
	 */
	protected HttpServletRequest getRequest() {
		return (HttpServletRequest) FacesContext.getCurrentInstance()
				.getExternalContext().getRequest();
	}


	/**
	 * Retorna a sessão aberta.
	 * 
	 * @return HttpSession
	 */
	private HttpSession getSession() {
		Object session = FacesContext.getCurrentInstance().getExternalContext()
				.getSession(false);
		if (session == null)
			return null;

		return (HttpSession) session;
	}

	/**
	 * gets e sets de paginacao
	 */
	public String getPagina() {
		return pagina;
	}

	public void setPagina(String pagina) {
		this.pagina = pagina;
	}

	public List<String> getPaginasView() {
		return paginasView;
	}

	public void setPaginasView(List<String> paginasView) {
		this.paginasView = paginasView;
	}

	public String getLinkpag() {
		return linkpag;
	}

	public String getPagInicio() {
		return pagInicio;
	}

	public String getPagFinal() {
		return pagFinal;
	}



	public void setDataCorrente(String dataCorrente) {
		this.dataCorrente = dataCorrente;
	}
}