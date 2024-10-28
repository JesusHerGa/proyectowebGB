package com.unu.proyectwebGB.controllers;


import java.io.IOException;
import java.util.Iterator;

import com.unu.proyectwebGB.beans.Autor;
import com.unu.proyectwebGB.models.EditorialesModel;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class EditorialesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EditorialesModel modelo = new EditorialesModel();
	
	public EditorialesController() {
		super();
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getParameter("op") == null) {
			listar(request, response);
			return;
		}
		String operacion = request.getParameter("op");
		switch (operacion) {

		case "listar":
			listar(request, response);
			break;

		case "nuevo":

			request.getRequestDispatcher("/editoriales/nuevoEditorial.jsp").forward(request, response);
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
			request.setAttribute("listaAutores", modelo.listarAutores());
			Iterator<Autor> it = modelo.listarAutores().iterator();
			while (it.hasNext()) {
				Autor a = it.next();
				System.out.println(a.getIdAutor() + " " + a.getNombre() + " " + a.getNacionalidad());
			}
			request.getRequestDispatcher("/autores/listaAutores.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
	private void insertar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			Autor miAutor= new Autor();
			miAutor.setNombre(request.getParameter("nombre"));
			miAutor.setNacionalidad(request.getParameter("nacionalidad"));
			if(modelo.insertarAutor(miAutor)>0) {
				request.getSession().setAttribute("exito","autor registrado satisfactoriamente");
								
			}
			else {
				request.getSession().setAttribute("fracaso","autor NO registrado satisfactoriamente");
				
			}
			response.sendRedirect(request.getContextPath()+"/AutoresController?op=listar");
		} catch (Exception ex) {
			ex.getStackTrace();
		}
	}
	private void obtener(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			String id = request.getParameter("id");
			Autor miAutor= modelo.obtenerAutor(Integer.parseInt(id));
			if(miAutor!= null) {
				request.setAttribute("autor", miAutor);
				request.getRequestDispatcher("/autores/editarAutor.jsp").forward(request, response);
				}
			else {
				response.sendRedirect(request.getContextPath()+"/error404.jsp");
			}
			
		} catch (Exception ex) {
			
		}
	}
	private void modificar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			Autor miAutor= new Autor();
			miAutor.setIdAutor(Integer.parseInt(request.getParameter("id")));
			miAutor.setNombre(request.getParameter("nombre"));
			miAutor.setNacionalidad(request.getParameter("nacionalidad"));
			request.setAttribute("autor", miAutor);
			if(modelo.modificarAutor(miAutor)>0) {
				request.getSession().setAttribute("exito","autor registrado satisfactoriamente");
								
			}
			else {
				request.getSession().setAttribute("fracaso","autor NO registrado satisfactoriamente");
				
			}
			response.sendRedirect(request.getContextPath()+"/AutoresController?op=listar");
		} catch (Exception ex) {
			ex.getStackTrace();
		}
	}
	
	private void eliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		try {
			int idautor = Integer.parseInt(request.getParameter("id"));
			if(modelo.eliminarAutor(idautor)> 0) {
				request.getSession().setAttribute("exito","autor eliminado satisfactoriamente");
			}
			else {
				request.getSession().setAttribute("fracaso","autor NO eliminado satisfactoriamente");
			}
			response.sendRedirect(request.getContextPath()+"/AutoresController?op=listar");
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
