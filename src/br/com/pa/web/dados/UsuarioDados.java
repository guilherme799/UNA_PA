package br.com.pa.web.dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import br.com.pa.web.bean.Usuario;
import br.com.pa.web.bean.Usuario.Tipo;

public class UsuarioDados {
	private Connection conn;
	private PreparedStatement stm;
	private ResultSet rs;
	
	public ArrayList<Usuario> obterUsuarios(Usuario usuario) throws Exception{
		try{
			conn = new ConnFactory().getConnection();
			ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
			String query = "SELECT id, login, senha, nome, " +
					"tipo, telefone, email, multa " +
					"FROM usuario %s";
			String where = "WHERE %s";
			String param = "0 = 0";
			
			for (java.lang.reflect.Method metodoGet : Usuario.class.getMethods()) {
				String nome = metodoGet.getName(); 
				if(nome.startsWith("get") && !nome.equals("getClass")){
					Object valor = metodoGet.invoke(usuario);
					String campo = nome.replace("get", "");
					
					if(valor != null){
						valor = valor.toString().toLowerCase();
						if(!valor.equals("0.0") && !valor.equals("0") && !valor.equals("")){
							param = param.concat(" AND " + campo + " = '" + valor + "'");
						}
					}
				}
			}
			
			where = String.format(where, param);
			query = String.format(query, where);
			
			stm = conn.prepareStatement(query);
			rs = stm.executeQuery();
			
			while(rs.next()){
				Usuario us = new Usuario();
				Tipo tipo = Tipo.valueOf(rs.getString("tipo"));
				
				us.setId(rs.getInt("id"));
				us.setLogin(rs.getString("login"));
				us.setSenha(rs.getString("senha"));
				us.setNome(rs.getString("nome"));
				us.setTelefone(rs.getString("telefone"));
				us.setTipo(tipo);
				us.setEmail(rs.getString("email"));
				us.setMulta(rs.getDouble("multa"));
				usuarios.add(us);
			}
			
			rs.close();
			stm.close();
			conn.close();
			
			return usuarios;
		}
		catch(Exception ex){
			throw ex;
		}
	}
}
