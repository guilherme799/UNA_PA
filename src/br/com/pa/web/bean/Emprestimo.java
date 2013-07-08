package br.com.pa.web.bean;

import java.util.Date;

/*
*Classe referente ao registro de emprestimos da biblioteca.
*/
public class Emprestimo extends Modelo{
	private int id_edicao;
	private int id_usuario;
	private Date data_emprestimo;
	private Date data_devolucao;
	private Date data_devolvido;
	
	public int getId_edicao() {
		return id_edicao;
	}
	public void setId_edicao(int id_edicao) {
		this.id_edicao = id_edicao;
	}
	public int getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
	public Date getData_devolvido() {
		return data_devolvido;
	}
	public void setData_devolvido(Date data_devolvido) {
		this.data_devolvido = data_devolvido;
	}
	public Date getData_devolcao() {
		return data_devolucao;
	}
	public void setData_devolcao(Date data_devolucao) {
		this.data_devolucao = data_devolucao;
	}
	public Date getData_emprestimo() {
		return data_emprestimo;
	}
	public void setData_emprestimo(Date data_emprestimo) {
		this.data_emprestimo = data_emprestimo;
	}
}
