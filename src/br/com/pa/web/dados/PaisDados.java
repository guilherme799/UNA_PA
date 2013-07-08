package br.com.pa.web.dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import br.com.pa.web.bean.Pais;

public class PaisDados {
	private Connection conn;
	private PreparedStatement stm;
	private ResultSet rs;
	
	public ArrayList<Pais> obterPaises(Pais pais) throws Exception{
		try{
		conn = new ConnFactory().getConnection();
		ArrayList<Pais> paises = new ArrayList<Pais>();
		String query = "SELECT id, nome FROM pais %s";
		String where = "WHERE %s";
		String param = "0 = 0";
		
		for (java.lang.reflect.Method metodoGet : Pais.class.getMethods()) {
			String nome = metodoGet.getName(); 
			if(nome.startsWith("get") && !nome.equals("getClass")){
				Object valor = metodoGet.invoke(pais);
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
			Pais ob = new Pais();
			
			ob.setId(rs.getInt("id"));
			ob.setNome(rs.getString("nome"));
			paises.add(ob);
		}
		
		rs.close();
		stm.close();
		conn.close();
		
		return paises;
		}
		catch(Exception ex){
			throw ex;
		}
	}

	public Pais criarPais(Pais pais) throws Exception {
		try{
			conn = new ConnFactory().getConnection();
			String query = "INSERT INTO pais (nome) values (?)";
			stm = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
			
			stm.setString(1, pais.getNome());
			stm.executeUpdate();
			rs = stm.getGeneratedKeys();
					
			while(rs.next())
				pais.setId(rs.getInt(0));
			
			rs.close();
			stm.close();
			conn.close();
			
			return pais;
		}
		catch(Exception ex){
			throw ex;
		}
	}
}
