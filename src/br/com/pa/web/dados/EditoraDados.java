package br.com.pa.web.dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import br.com.pa.web.bean.Editora;

public class EditoraDados {
	private Connection conn;
	private PreparedStatement stm;
	private ResultSet rs;
	
	public ArrayList<Editora> obterEditoras(Editora editora) throws Exception{
		try{
			conn = new ConnFactory().getConnection();
			ArrayList<Editora> editoras = new ArrayList<Editora>();
			String query = "SELECT id, nome FROM editora %s";
			String where = "WHERE %s";
			String param = "0 = 0";
			
			for (java.lang.reflect.Method metodoGet : Editora.class.getMethods()) {
				String nome = metodoGet.getName(); 
				if(nome.startsWith("get") && !nome.equals("getClass")){
					Object valor = metodoGet.invoke(editora);
					String campo = nome.replace("get", "");
					
					if(valor != null){
						valor = valor.toString().toLowerCase();
						if(!valor.equals("0") && !valor.equals("")){
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
				Editora ed = new Editora();
				
				ed.setId(rs.getInt("id"));
				ed.setNome(rs.getString("nome"));
				editoras.add(ed);
			}
			
			rs.close();
			stm.close();
			conn.close();
			
			return editoras;
		}
		catch(Exception ex){
			throw ex;
		}
	}
	
	public Editora criarEditora(Editora editora) throws Exception{
		try{
			conn = new ConnFactory().getConnection();
			String query = "INSERT INTO editora (nome) values (?)";
			stm = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
			
			stm.setString(1, editora.getNome());
			stm.executeUpdate();
			rs = stm.getGeneratedKeys();
					
			while(rs.next())
				editora.setId(rs.getInt(0));
			
			rs.close();
			stm.close();
			conn.close();
			
			return editora;
		}
		catch(Exception ex){
			throw ex;
		}
	}
}
