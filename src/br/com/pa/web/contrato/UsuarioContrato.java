package br.com.pa.web.contrato;

import java.util.ArrayList;

import br.com.pa.web.bean.Usuario;
import br.com.pa.web.dados.UsuarioDados;

public class UsuarioContrato implements IContrato<Usuario> {

	@Override
	public ArrayList<Usuario> obterRegistro(Usuario modelo) throws Exception {
		UsuarioDados dados = new UsuarioDados();
		ArrayList<Usuario> usuarios = dados.obterUsuarios(modelo);
		
		return usuarios;
	}

	@Override
	public Usuario criarRegistro(Usuario modelo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean apagarRegistro(Usuario modelo) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Usuario atualizarRegistro(int id, Usuario modelo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
