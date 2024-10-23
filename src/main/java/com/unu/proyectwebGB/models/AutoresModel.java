package com.unu.proyectwebGB.models;
import java.util.ArrayList;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;




import com.unu.proyectwebGB.beans.*;

public class AutoresModel extends conexion{
	CallableStatement cs;
	ResultSet rs;


	
	public List<Autor> listarAutores() throws SQLException{
		 try {
				 List<Autor> lista = new ArrayList<>();
				 String sql = "CALL sp_listarAutores()";
				 this.abrirConexion();
				 cs = conexion.prepareCall(sql);
				 rs = cs.executeQuery();
				 while(rs.next()){
				 Autor autor = new Autor();
				 autor.setIdAutor(rs.getInt("idautor"));
				 autor.setNombre(rs.getString("nombre"));
				 autor.setNacionalidad(rs.getString("nacionalidad"));
				 lista.add(autor);
			 }
			 this.cerrarConexion();
			 return lista;
			 } catch (SQLException ex) {
			 Logger.getLogger(AutoresModel.class.getName()).log(Level.SEVERE, null, ex);
			 this.cerrarConexion();;
			 return null;
			 }
			 }

	

}

