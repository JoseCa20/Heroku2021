package com.example.demo.modelo;

import javax.persistence.*;

@Entity
@Table(name = "producto")
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "Nombre", length = 60, nullable = false)
	private String nombre;

	@Column(name = "Categoria", length = 60, nullable = false)
	private String categoria;

	@Column(name = "Descripcion", length = 60, nullable = false)
	private String descripcion;

	@Column(name = "Precio", length = 60, nullable = false)
	private Integer precio;

	public Producto() {

	}	

	public Producto(Long id, String nombre, String categoria, String descripcion, Integer precio) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.categoria = categoria;
		this.descripcion = descripcion;
		this.precio = precio;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getPrecio() {
		return precio;
	}

	public void setPrecio(Integer precio) {
		this.precio = precio;
	}	

}
