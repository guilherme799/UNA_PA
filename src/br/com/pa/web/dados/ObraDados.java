package br.com.pa.web.dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import br.com.pa.web.bean.Obra;

public class ObraDados {
	private Connection conn;
	private PreparedStatement stm;
	private ResultSet rs;
	
	public Obra criarObra(Obra obra) throws Exception{
		try{
			conn = new ConnFactory().getConnection();
			String query = "INSERT INTO obra (id_editora, id_pais, isbn, titulo, lancamento, pagina, sinopse, imagem)" +
			"values (?, ?, ?, ?, ?, ?, ?, ?)";
			stm = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
			
			stm.setInt(1, obra.getId_editora());
			stm.setInt(2, obra.getId_pais());
			stm.setString(3, obra.getIsbn());
			stm.setString(4, obra.getTitulo());
			stm.setString(5, obra.getLancamento());
			stm.setInt(6, obra.getPagina());
			stm.setString(7, obra.getSinopse());
			stm.setString(8, obra.getImagem());
			
			stm.executeUpdate();
			rs = stm.getGeneratedKeys();

			while(rs.next())
				obra.setId(rs.getInt(1));
			
			rs.close();
			stm.close();
			conn.close();
			return obra;
		}
		catch (Exception ex){
			throw ex;
		}
	}
	
	public ArrayList<Obra> obterObras(Obra obra) throws Exception{
		try{
		conn = new ConnFactory().getConnection();
		ArrayList<Obra> obras = new ArrayList<Obra>();
		String query = "SELECT id, tipo_formato, id_editora, paginas, " +
				"ano_lancamento, autor, sinopse, assunto, isbn, titulo, idioma " +
				"FROM obra %s";
		String where = "WHERE %s";
		String param = "0 = 0";
		
		for (java.lang.reflect.Method metodoGet : Obra.class.getMethods()) {
			String nome = metodoGet.getName(); 
			if(nome.startsWith("get") && !nome.equals("getClass")){
				Object valor = metodoGet.invoke(obra);
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
			Obra ob = new Obra();
			
			ob.setId(rs.getInt("id"));
			ob.setId_editora(rs.getInt("id_editora"));
			ob.setId_pais(rs.getInt("id_pais"));
			ob.setPagina(rs.getInt("pagina"));
			ob.setLancamento(rs.getString("lancamento"));
			ob.setSinopse(rs.getString("sinopse"));
			ob.setIsbn(rs.getString("isbn"));
			ob.setImagem(rs.getString("imagem"));
			obras.add(ob);
		}
		
		rs.close();
		stm.close();
		conn.close();
		
		return obras;
		}
		catch(Exception ex){
			throw ex;
		}
	}
}
