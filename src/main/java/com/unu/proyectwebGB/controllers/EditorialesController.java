package com.unu.proyectwebGB.controllers;
import jakarta.servlet.ServletException;

import java.io.IOException;
import java.util.Iterator;

import com.unu.proyectwebGB.beans.Autor;
import com.unu.proyectwebGB.beans.Editorial;
import com.unu.proyectwebGB.models.EditorialesModel;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class EditorialesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EditorialesModel modeloedt = new EditorialesModel();
	
	public EditorialesController() {
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
			request.setAttribute("listaEditores", modeloedt.listarEditoriales());
			Iterator<Editorial> it = modeloedt.listarEditoriales().iterator();
			while (it.hasNext()) {
				Editorial e = it.next();
				System.out.println(e.getIdEditorial() + " " + e.getNombre() + " " + e.getContacto()+ " " + e.getTelefono());
			}
			request.getRequestDispatcher("/editoriales/listaEditores.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
	private void insertar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			Editorial miEditorial= new Editorial();
			miEditorial.setNombre(request.getParameter("nombre"));
			miEditorial.setContacto(request.getParameter("contacto"));
			miEditorial.setTelefono(request.getParameter("telefono"));
			if(modeloedt.insertarEditorial(miEditorial)>0) {
				request.getSession().setAttribute("exito","editorial registrada satisfactoriamente");
								
			}
			else {
				request.getSession().setAttribute("fracaso","editorial NO registrada satisfactoriamente");
				
			}
			response.sendRedirect(request.getContextPath()+"/EditorialesController?op=listar");
		} catch (Exception ex) {
			ex.getStackTrace();
		}
	}
	private void obtener(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			String id = request.getParameter("id");
			Editorial miEditorial= modeloedt.obtenerEditorial(Integer.parseInt(id));
			if(miEditorial!= null) {
				request.setAttribute("editorial", miEditorial);
				request.getRequestDispatcher("/editoriales/editarEditorial.jsp").forward(request, response);
				}
			else {
				response.sendRedirect(request.getContextPath()+"/error404.jsp");
			}
			
		} catch (Exception ex) {
			
		}
	}
	private void modificar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			Editorial miEditorial= new Editorial();
			miEditorial.setIdEditorial(Integer.parseInt(request.getParameter("id")));
			miEditorial.setNombre(request.getParameter("nombre"));
			miEditorial.setContacto(request.getParameter("contacto"));
			miEditorial.setTelefono(request.getParameter("telefono"));
			request.setAttribute("editorial", miEditorial);
			if(modeloedt.modificarEditorial(miEditorial)>0) {
				request.getSession().setAttribute("exito","editorial modificado satisfactoriamente");
								
			}
			else {
				request.getSession().setAttribute("fracaso","editorial NO modificada satisfactoriamente");
				
			}
			response.sendRedirect(request.getContextPath()+"/EditorialesController?op=listar");
		} catch (Exception ex) {
			ex.getStackTrace();
		}
	}
	
	private void eliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		try {
			int ideditorial = Integer.parseInt(request.getParameter("id"));
			if(modeloedt.eliminarEditorial(ideditorial)> 0) {
				request.getSession().setAttribute("exito","editorial eliminado satisfactoriamente");
			}
			else {
				request.getSession().setAttribute("fracaso","editorial NO eliminado satisfactoriamente");
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
