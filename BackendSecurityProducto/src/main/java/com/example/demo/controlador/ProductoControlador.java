package com.example.demo.controlador;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Servicio.ProductoService;
import com.example.demo.modelo.Producto;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/productos")
public class ProductoControlador {
	
	@Autowired
	private ProductoService productoService;
	
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Producto producto){
		return ResponseEntity.status(HttpStatus.CREATED).body(productoService.save(producto));
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable(value = "id")  Long productoId){
		Optional<Producto> producto = productoService.findById(productoId);
		if(!producto.isPresent()) {
			return ResponseEntity.notFound().build();	
		}
		return ResponseEntity.ok(producto);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update (@RequestBody Producto productoDetalle, @PathVariable(value="id") Long productoId){
		Optional<Producto> producto = productoService.findById(productoId);
		if(!producto.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		producto.get().setNombre(productoDetalle.getNombre());
		producto.get().setCategoria(productoDetalle.getCategoria());
		producto.get().setDescripcion(productoDetalle.getDescripcion());
		producto.get().setPrecio(productoDetalle.getPrecio());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(productoService.save(producto.get()));
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(value="id") Long productoId){
		if(!productoService.findById(productoId).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		productoService.deleteById(productoId);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping
	public List<Producto> readAll(){
		List<Producto> productos = StreamSupport
				.stream(productoService.findAll().spliterator(), false)
				.collect(Collectors.toList());
		
		return productos;
	}
	
}
