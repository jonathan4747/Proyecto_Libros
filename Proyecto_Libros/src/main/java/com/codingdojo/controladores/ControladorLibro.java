package com.codingdojo.controladores;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codingdojo.modelos.Libro;
import com.codingdojo.servicios.ServicioLibro;

@RestController
public class ControladorLibro {
	
	private final ServicioLibro servicioLibro;
	public ControladorLibro(ServicioLibro servicioLibro) {
		this.servicioLibro= servicioLibro;
	} 
	
	@RequestMapping("/api/libros")
	public List<Libro> index(){
		return servicioLibro.allLibros();
	}
	
	@RequestMapping(value="/api/libros", method=RequestMethod.POST)
	public Libro libroCreate(@RequestParam(value="titulo") String titulo,@RequestParam(value="descripcion") String descripcion,
				@RequestParam(value="lenguaje") String lenguaje, @RequestParam(value="numerodepaginas") Integer numerodepaginas){
		Libro libro = new Libro(titulo,descripcion,lenguaje,numerodepaginas);
			return servicioLibro.createLibro(libro);
	}
	@RequestMapping("/api/libros/{id}")
	public Libro show(@PathVariable("id") Long id ) {
		Libro libro = servicioLibro.findLibro(id);
		return libro;
	}
	
	@RequestMapping(value="/api/libros/editar/{id}", method=RequestMethod.PUT)
	public Libro Edit(@PathVariable("id") Long id,@RequestParam(value="titulo") String titulo,@RequestParam(value="descripcion") String descripcion,
			@RequestParam(value="lenguaje") String lenguaje, @RequestParam(value="numerodepaginas") Integer numerodepaginas ) {
		Libro libro = servicioLibro.findLibro(id);
		libro.setTitulo(titulo);
		libro.setDescripcion(descripcion);
		libro.setLenguaje(lenguaje);
		libro.setNumerodepaginas(numerodepaginas);
		return servicioLibro.UpdateLibro(libro);
	}
	@RequestMapping(value="/api/libros/eliminar/{id}", method=RequestMethod.DELETE)
	public long Eliminar(@PathVariable("id") long id) {
		return servicioLibro.DeleteLibro(id); 
	}

}
