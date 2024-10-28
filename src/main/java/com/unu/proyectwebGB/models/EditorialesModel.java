package com.unu.proyectwebGB.models;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.unu.proyectwebGB.beans.Autor;


public class EditorialesModel extends conexion{
		CallableStatement cs;
		ResultSet rs;


		
		public List<Editorial> listarEditoriales() throws SQLException{
			 try {
					 List<Editorial> lista = new ArrayList<>();
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

		public int insertarAutor(Autor autor) {
			try {
				int filasAfectadas=0;
				String sql = "CALL sp_insertarAutor(?,?)";
				this.abrirConexion();
				cs = conexion.prepareCall(sql);
				cs.setString(1, autor.getNombre());
				cs.setString(2, autor.getNacionalidad());
				filasAfectadas = cs.executeUpdate();
				this.cerrarConexion();
				return filasAfectadas;
			} catch (Exception e) {
				// TODO: handle exception
				this.cerrarConexion();
				return 0;
			}
			
			
		}
		public Autor obtenerAutor(int idautor) {
			Autor autor = null;
			try {
				
				String sql = "CALL sp_obtenerAutor(?)";
				this.abrirConexion();
				cs = conexion.prepareCall(sql);
				cs.setInt(1,idautor);
				rs= cs.executeQuery();
				if(rs.next()) {
					//Autor autor = new Autor();
					autor = new Autor();
					autor.setIdAutor(rs.getInt("idautor"));
					autor.setNombre(rs.getString("nombre"));
					autor.setNacionalidad(rs.getString("nacionalidad"));
					this.cerrarConexion();
					return autor;
					
				}
				return null;
				
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
				this.cerrarConexion();
				return null;
			}
			
		}

		public int modificarAutor(Autor autor) throws SQLException {
			try {
				int filasAfectadas = 0;
				String sql = "CALL sp_modificarAutor(?,?,?)";
				this.abrirConexion();
				cs = conexion.prepareCall(sql);
				cs.setInt(1, autor.getIdAutor());
				cs.setString(2, autor.getNombre());
				cs.setString(3, autor.getNacionalidad());
				filasAfectadas = cs.executeUpdate();
				this.cerrarConexion();
				return filasAfectadas;
			} catch (SQLException ex) {
				Logger.getLogger(AutoresModel.class.getName()).log(Level.SEVERE, null, ex);
				this.cerrarConexion();
				return 0;
			}
		}

		
		public int eliminarAutor(int idautor) throws SQLException {
			try {
				int filasAfectadas = 0;
				String sql ="CALL sp_eliminarAutor(?)";
				this.abrirConexion();
				cs = conexion.prepareCall(sql);
				cs.setInt(1,idautor);
				filasAfectadas = cs.executeUpdate();
				this.cerrarConexion();
				return filasAfectadas;
				
				
			} catch (Exception e) {
				// TODO: handle exception
				this.cerrarConexion();
				return 0;
			}
			
		}
	}

