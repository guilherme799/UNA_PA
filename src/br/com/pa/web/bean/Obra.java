package br.com.pa.web.bean;

/*
*Adicionando um comentário à classe Obra.
*/
public class Obra extends Modelo{
	private int id_editora;
	private int id_pais;
	private String isbn;
	private String titulo;
	private String lancamento;
	private int pagina;
	private String sinopse;
	private String imagem;
	
	/*
	 * Getters and Setter
	 */
	public int getId_editora() {
		return id_editora;
	}
	public void setId_editora(int id_editora) {
		this.id_editora = id_editora;
	}
	public int getId_pais() {
		return id_pais;
	}
	public void setId_pais(int id_pais) {
		this.id_pais = id_pais;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getLancamento() {
		return lancamento;
	}
	public void setLancamento(String lancamento) {
		this.lancamento = lancamento;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public int getPagina() {
		return pagina;
	}
	public void setPagina(int pagina) {
		this.pagina = pagina;
	}
	public String getSinopse() {
		return sinopse;
	}
	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}
	public String getImagem() {
		return imagem;
	}
	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
}
