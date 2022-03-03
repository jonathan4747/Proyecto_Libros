package com.codingdojo.servicios;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.modelos.Libro;
import com.codingdojo.repositorios.RepositorioLibro;

@Service
public class ServicioLibro {
private final RepositorioLibro repositorioLibro;
	
	public ServicioLibro(RepositorioLibro repositorioLibro) {
		this.repositorioLibro=repositorioLibro;
	}
	//Mostrar todos los libros
	public List<Libro> allLibros(){
		return repositorioLibro.findAll();
	}
	//crear
	public Libro createLibro(Libro b) {
		return repositorioLibro.save(b);
	}
	//recueperar un libro
	public Libro findLibro(Long id) {
		Optional<Libro> optionalLibro=repositorioLibro.findById(id);
		if(optionalLibro.isPresent()) {
			return optionalLibro.get();
		}
		else {
			return null;
		}
		
	}
	//editar un libro
	public Libro UpdateLibro(Libro b) {
		return repositorioLibro.save(b);
	}
	
	//eliminar
	public Long DeleteLibro(long id) {
		return repositorioLibro.deleteById(id);
	}

}
