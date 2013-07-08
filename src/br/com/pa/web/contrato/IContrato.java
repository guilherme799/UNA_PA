package br.com.pa.web.contrato;

import java.util.ArrayList;

import br.com.pa.web.bean.Modelo;


public interface IContrato<T extends Modelo> {
	
	public ArrayList<T> obterRegistro(T modelo) throws Exception;
	public T criarRegistro(T modelo) throws Exception;
	public boolean apagarRegistro(T modelo) throws Exception;
	public T atualizarRegistro(int id, T modelo) throws Exception;
	
}
