package net.itinajero.app.controller;

import net.itinajero.app.model.Pelicula;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

@Controller
public class HomeController {

	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String goHome(){
		return "home";
	}


	@RequestMapping(value = "/", method=RequestMethod.GET)
	public String mostrarPrincipal(Model model) {
		List<Pelicula> peliculas = getLista();
//		peliculas.add("Rapido y furioso");
//		peliculas.add("El aro 2");
//		peliculas.add("Alies");
		model.addAttribute("peliculas", peliculas);
		return "home";
	}


	@RequestMapping(value="/detail")
	public String mostrarDetalle(Model model){
		String tituloPelicula = "Rapido y furioso";
		int duracion = 136;
		double precioEntrada = 50;

		model.addAttribute("titulo", tituloPelicula);
		model.addAttribute("dramacion", duracion);
		model.addAttribute("precio", precioEntrada);
		return "detalle";
	}

	//Metodo para generar una lista de objetos de Modelo (pelicula)
	private List<Pelicula> getLista(){
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		List<Pelicula> lista = null;
		try {
			lista = new LinkedList<Pelicula>();

			Pelicula pelicula1 = new Pelicula();
			pelicula1.setId(1);
			pelicula1.setTitulo("Power Rangers");
			pelicula1.setDuracion(120);
			pelicula1.setClasificacion("B");
			pelicula1.setGenero("Aventura");
			pelicula1.setFechaEstreno(formatter.parse("02-05-2017"));

			Pelicula pelicula2 = new Pelicula();
			pelicula1.setId(2);
			pelicula1.setTitulo("La bella y la bestia");
			pelicula1.setDuracion(132);
			pelicula1.setClasificacion("A");
			pelicula1.setGenero("Infantil");
			pelicula1.setFechaEstreno(formatter.parse("20-05-2017"));

			Pelicula pelicula3 = new Pelicula();
			pelicula1.setId(3);
			pelicula1.setTitulo("contratiempo");
			pelicula1.setDuracion(106);
			pelicula1.setClasificacion("B");
			pelicula1.setGenero("Thriller");
			pelicula1.setFechaEstreno(formatter.parse("28-05-2017"));

			//Agregamos los objetos Pelicula a la lista
			lista.add(pelicula1);
			lista.add(pelicula2);
			lista.add(pelicula3);
			return lista;

		} catch (ParseException e) {
			System.out.println("");
			return null;
		}
	}

	
}
