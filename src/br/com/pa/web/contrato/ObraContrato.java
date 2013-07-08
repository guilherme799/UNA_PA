package br.com.pa.web.contrato;

import java.util.ArrayList;

import br.com.pa.web.bean.Obra;
import br.com.pa.web.dados.ObraDados;


public class ObraContrato implements IContrato<Obra>{

	@Override
	public ArrayList<Obra> obterRegistro(Obra modelo) throws Exception {
		ObraDados dados = new ObraDados();
		ArrayList<Obra> obras = dados.obterObras(modelo);
		
		return obras;
	}

	@Override
	public Obra criarRegistro(Obra modelo) throws Exception {
		ObraDados dados = new ObraDados();
		Obra obra = dados.criarObra(modelo);
		return obra;
	}

	@Override
	public boolean apagarRegistro(Obra modelo) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Obra atualizarRegistro(int id, Obra modelo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	

}
