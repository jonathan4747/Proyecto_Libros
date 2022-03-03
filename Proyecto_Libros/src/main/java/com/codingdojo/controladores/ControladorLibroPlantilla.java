package com.codingdojo.controladores;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.modelos.Libro;
import com.codingdojo.servicios.ServicioLibro;

@Controller
public class ControladorLibroPlantilla {
	private final ServicioLibro servicioLibro;
	public ControladorLibroPlantilla(ServicioLibro servicioLibro) {
		this.servicioLibro= servicioLibro;
	} 
	@RequestMapping( value = "/libros/{id}", method = RequestMethod.GET )
	public String Ver(@PathVariable("id") Long id,Model model) {
		Libro libro = servicioLibro.findLibro(id);
		System.out.println("esto es el libro"+libro);
		model.addAttribute("titulo", libro.getTitulo());
		model.addAttribute("descripcion", libro.getDescripcion());
		model.addAttribute("lenguaje", libro.getLenguaje());
		model.addAttribute("paginas", libro.getNumerodepaginas());
		return "index.jsp";
	}
	@RequestMapping( value = "/libros", method = RequestMethod.GET )
	public String Lista(Model model , HttpSession session) {
		List<Libro> libros = servicioLibro.allLibros();
		model.addAttribute("listaLibros", libros);
		return "lista.jsp";
		
	}
}
