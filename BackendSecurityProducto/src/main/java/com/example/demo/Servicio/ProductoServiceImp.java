package com.example.demo.Servicio;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.modelo.Producto;
import com.example.demo.repositorio.ProductoRepositorio;

@Service
public class ProductoServiceImp implements ProductoService{
	
	@Autowired
	private ProductoRepositorio productoRepositorio;

	@Override
	@Transactional(readOnly = true)
	public Iterable<Producto> findAll() {		
		return productoRepositorio.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Producto> findAll(Pageable pageable) {		
		return productoRepositorio.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Producto> findById(Long id) {		
		return productoRepositorio.findById(id);
	}

	@Override
	@Transactional
	public Producto save(Producto producto) {		
		return productoRepositorio.save(producto);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		productoRepositorio.deleteById(id);		
	}

	
	
}
