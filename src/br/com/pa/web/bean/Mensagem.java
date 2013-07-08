package br.com.pa.web.bean;

public class Mensagem {
	private String css;
	private String corpo;
	private String titulo;
	
	public Mensagem(TipoMensagem tipo){
		this.css = retornaCss(tipo);
		this.titulo = retornaTitulo(tipo);
	}
	
	public Mensagem(TipoMensagem tipo, PadraoMensagem padrao){
		this.css = retornaCss(tipo);
		this.titulo = retornaTitulo(tipo);
		this.setCorpo(retornaMensagem(padrao));
	}
	
	public String getCss() {
		return css;
	}
	
	public String getCorpo() {
		return corpo;
	}

	public void setCorpo(String corpo) {
		this.corpo = corpo;
	}

	public String getTitulo() {
		return titulo;
	}

	private String retornaCss(TipoMensagem tipo){
		switch (tipo) {
		case ERRO:
			return "alert-erro";
		case INFORMACAO:
			return "alert-info";
		case SUCESSO:
			return "alert-success";
		default:
			return "";
		}
	}
	
	private String retornaTitulo(TipoMensagem tipo){
		switch (tipo) {
		case AVISO:
			return "Aviso";
		case ERRO:
			return "Erro";
		case INFORMACAO:
			return "Informação";
		case SUCESSO:
			return "Sucesso";
		default:
			return "";
		}
	}
	
	private String retornaMensagem(PadraoMensagem padrao){
		switch (padrao) {
		case AlTERAR:
			return "Registro alterado com sucesso!";
		case CRIAR:
			return "Registro adicionado com sucesso!";
		case DELETAR:
			return "Registro apagado com sucesso!";
		case RECUPERAR:
			return "Registro recuperado com sucesso!";
		default:
			return "";
		}
	}
}
