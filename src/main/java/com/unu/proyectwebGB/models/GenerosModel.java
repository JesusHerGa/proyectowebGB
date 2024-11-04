package com.unu.proyectwebGB.models;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.unu.proyectwebGB.beans.Genero;

public class GenerosModel extends conexion{
		CallableStatement cs;
		ResultSet rs;


		
		public List<Genero> listarGeneros() throws SQLException{
			 try {
					 List<Genero> lista = new ArrayList<>();
					 String sql = "CALL sp_listarGeneros()";
					 this.abrirConexion();
					 cs = conexion.prepareCall(sql);
					 rs = cs.executeQuery();
					 while(rs.next()){
					 Genero genero = new Genero();
					 genero.setIdGenero(rs.getInt("idgenero"));
					 genero.setNombre(rs.getString("nombre"));
					 genero.setDescripcion(rs.getNString("descripcion"));
					 lista.add(genero);
						
				 }
				 this.cerrarConexion();
				 return lista;
				 } catch (SQLException ex) {
				 Logger.getLogger(EditorialesModel.class.getName()).log(Level.SEVERE, null, ex);
				 this.cerrarConexion();;
				 return null;
				 }
				 }

		public int insertarGenero(Genero genero) {
			try {
				int filasAfectadas=0;
				String sql = "CALL sp_insertarGenero(?,?)";
				this.abrirConexion();
				cs = conexion.prepareCall(sql);
				cs.setString(1, genero.getNombre());
				cs.setString(2, genero.getDescripcion());
				filasAfectadas = cs.executeUpdate();
				this.cerrarConexion();
				return filasAfectadas;
			} catch (Exception e) {
				// TODO: handle exception
				this.cerrarConexion();
				return 0;
			}
			
			
		}
		public Genero obtenerGenero(int idgenero) {
			Genero genero = null;
			try {
				
				String sql = "CALL sp_obtenerGenero(?)";
				this.abrirConexion();
				cs = conexion.prepareCall(sql);
				cs.setInt(1,idgenero);
				rs= cs.executeQuery();
				if(rs.next()) {
					
					genero = new Genero();
					genero.setIdGenero(rs.getInt("idgenero"));
					genero.setNombre(rs.getString("nombre"));
					genero.setDescripcion(rs.getString("descripcion"));
					this.cerrarConexion();
					return genero;
					
				}
				return null;
				
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
				this.cerrarConexion();
				return null;
			}
			
		}

		public int modificarGenero(Genero genero) throws SQLException {
			try {
				int filasAfectadas = 0;
				String sql = "CALL sp_modificarGenero(?,?,?)";
				this.abrirConexion();
				cs = conexion.prepareCall(sql);
				cs.setInt(1, genero.getIdGenero());
				cs.setString(2, genero.getNombre());
				cs.setString(3, genero.getDescripcion());
				filasAfectadas = cs.executeUpdate();
				this.cerrarConexion();
				return filasAfectadas;
			} catch (SQLException ex) {
				Logger.getLogger(GenerosModel.class.getName()).log(Level.SEVERE, null, ex);
				this.cerrarConexion();
				return 0;
			}
		}

		
		public int eliminarGenero(int idgenero) throws SQLException {
			try {
				int filasAfectadas = 0;
				String sql ="CALL sp_eliminarGenero(?)";
				this.abrirConexion();
				cs = conexion.prepareCall(sql);
				cs.setInt(1,idgenero);
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


