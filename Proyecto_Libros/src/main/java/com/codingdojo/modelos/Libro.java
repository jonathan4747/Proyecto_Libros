package com.codingdojo.modelos;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
@Entity
@Table (name="libros")
public class Libro {
	@Id
	@GeneratedValue ( strategy = GenerationType.IDENTITY )
	private long id;
	@NotNull
	@Size(min=5,max=200)
	private String titulo;
	@NotNull
	@Size(min=5,max=200)
	private String descripcion;
	@NotNull
	@Size(min=3,max=40)
	private String lenguaje;
	@NotNull
	@Min(100)
	private Integer numerodepaginas;
	// Esto no permitirá que la columna createdAt se actualice después de la creación
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
	
	public Libro() {
	}

	public Libro(String titulo,String descripcion, String lenguaje,Integer numerodepaginas) {
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.lenguaje = lenguaje;
		this.numerodepaginas = numerodepaginas;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getLenguaje() {
		return lenguaje;
	}

	public void setLenguaje(String lenguaje) {
		this.lenguaje = lenguaje;
	}

	public Integer getNumerodepaginas() {
		return numerodepaginas;
	}

	public void setNumerodepaginas(Integer numerodepaginas) {
		this.numerodepaginas = numerodepaginas;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
    
	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
    
}
