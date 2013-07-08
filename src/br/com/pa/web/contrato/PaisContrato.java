package br.com.pa.web.contrato;

import java.util.ArrayList;

import br.com.pa.web.bean.Pais;
import br.com.pa.web.dados.PaisDados;

public class PaisContrato implements IContrato<Pais> {

	@Override
	public ArrayList<Pais> obterRegistro(Pais modelo) throws Exception {
		PaisDados dados = new PaisDados();
		ArrayList<Pais> paises = dados.obterPaises(modelo);
		return paises;
	}

	@Override
	public Pais criarRegistro(Pais modelo) throws Exception {
		PaisDados dados = new PaisDados();
		Pais pais = dados.criarPais(modelo);
		return pais;
	}

	@Override
	public boolean apagarRegistro(Pais modelo) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Pais atualizarRegistro(int id, Pais modelo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
