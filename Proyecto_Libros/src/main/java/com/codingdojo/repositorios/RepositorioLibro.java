package com.codingdojo.repositorios;
import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.codingdojo.modelos.Libro;

@Repository
public interface RepositorioLibro extends CrudRepository<Libro, Long>{
	// este método recupera todos los libros de la base de datos
		List<Libro> findAll();
		// este método encuentra libros con descripciones que contienen la cadena de búsqueda
		Libro findById(long id);
		// este método cuenta cuántos títulos contienen una determinada cadena
		Long countByTituloContaining(String titulo);
		// este método elimina un libro que comienza con un título específico
		Long deleteByTituloStartingWith(String tilulo);
		
		Long deleteById(long id);

}
