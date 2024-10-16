package com.unu.proyectwebGB.models;
import java.util.ArrayList;
import java.util.List;

import com.unu.proyectwebGB.beans.*;
public class AutoresModel {

	public List<Autor> listaAutores(){
		ArrayList<Autor> autores = new ArrayList<>();
		autores.add(new Autor(1,"Garcia","Mexicano"));
		autores.add(new Autor(2,"Borges","Argentino"));
		autores.add(new Autor(3,"Hernandez","Peruano"));
		return autores;
	}
		
}
