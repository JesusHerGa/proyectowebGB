package com.unu.proyectwebGB.controllers;
import jakarta.servlet.ServletException;

import java.io.IOException;
import java.util.Iterator;

import com.unu.proyectwebGB.beans.Genero;
import com.unu.proyectwebGB.models.GenerosModel;


import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class GenerosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	GenerosModel modelognr = new GenerosModel();
	
	public GenerosController() {
		super();
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		String operacion = request.getParameter("op");
		if (request.getParameter("op") == null) {
			listar(request, response);
			return;
		}
		switch (operacion) {

		case "listar":
			listar(request, response);
			break;

		case "nuevo":

			request.getRequestDispatcher("/generos/nuevoGenero.jsp").forward(request, response);
			break;
		case "insertar":
			insertar(request, response);
			break;
		case "modificar":
			modificar(request, response);
			break;	
		case "obtener":
			obtener(request, response);
			break;
		
		case "eliminar":
			eliminar(request, response);
			break;	

		}
	}

	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setAttribute("listaGeneros", modelognr.listarGeneros());
			Iterator<Genero> it = modelognr.listarGeneros().iterator();
			while (it.hasNext()) {
				Genero e = it.next();
				System.out.println(e.getIdGenero() + " " + e.getNombre() + " " + e.getDescripcion()+ " " );
			}
			request.getRequestDispatcher("/generos/listaGeneros.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
	private void insertar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			Genero miGenero= new Genero();
			miGenero.setNombre(request.getParameter("nombre"));
			miGenero.setDescripcion(request.getParameter("descripcion"));
			if(modelognr.insertarGenero(miGenero)>0) {
				request.getSession().setAttribute("exito","Genero registrado satisfactoriamente");
								
			}
			else {
				request.getSession().setAttribute("fracaso","Genero NO registrada satisfactoriamente");
				
			}
			response.sendRedirect(request.getContextPath()+"/GenerosController?op=listar");
		} catch (Exception ex) {
			ex.getStackTrace();
		}
	}
	private void obtener(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			String id = request.getParameter("id");
			Genero miGenero= modelognr.obtenerGenero(Integer.parseInt(id));
			if(miGenero!= null) {
				request.setAttribute("genero", miGenero);
				request.getRequestDispatcher("/generos/editarGenero.jsp").forward(request, response);
				}
			else {
				response.sendRedirect(request.getContextPath()+"/error404.jsp");
			}
			
		} catch (Exception ex) {
			
		}
	}
	private void modificar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			Genero miGenero= new Genero();
			miGenero.setIdGenero(Integer.parseInt(request.getParameter("id")));
			miGenero.setNombre(request.getParameter("nombre"));
			miGenero.setDescripcion(request.getParameter("descripcion"));
			request.setAttribute("genero", miGenero);
			if(modelognr.modificarGenero(miGenero)>0) {
				request.getSession().setAttribute("exito","Genero modificado satisfactoriamente");
								
			}
			else {
				request.getSession().setAttribute("fracaso","Genero NO modificado satisfactoriamente");
				
			}
			response.sendRedirect(request.getContextPath()+"/GenerosController?op=listar");
		} catch (Exception ex) {
			ex.getStackTrace();
		}
	}
	
	private void eliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		try {
			int idgenero = Integer.parseInt(request.getParameter("id"));
			if(modelognr.eliminarGenero(idgenero)> 0) {
				request.getSession().setAttribute("exito","Genero eliminado satisfactoriamente");
			}
			else {
				request.getSession().setAttribute("fracaso","Genero NO eliminado satisfactoriamente");
			}
			response.sendRedirect(request.getContextPath()+"/EditorialesController?op=listar");
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}
	
	
}
