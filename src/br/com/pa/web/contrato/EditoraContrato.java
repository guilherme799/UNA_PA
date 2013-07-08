package br.com.pa.web.contrato;

import java.util.ArrayList;
import br.com.pa.web.bean.Editora;
import br.com.pa.web.dados.EditoraDados;

public class EditoraContrato implements IContrato<Editora> {

	@Override
	public ArrayList<Editora> obterRegistro(Editora modelo) throws Exception {
		EditoraDados dados = new EditoraDados();
		ArrayList<Editora> editoras = dados.obterEditoras(modelo);
		return editoras;
	}

	@Override
	public Editora criarRegistro(Editora modelo) throws Exception {
		EditoraDados dados = new EditoraDados();
		Editora editora = dados.criarEditora(modelo);
		return editora;
	}

	@Override
	public boolean apagarRegistro(Editora modelo) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Editora atualizarRegistro(int id, Editora modelo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
}
