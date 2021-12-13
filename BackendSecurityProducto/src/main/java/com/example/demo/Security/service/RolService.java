package com.example.demo.Security.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Security.entity.Rol;
import com.example.demo.Security.enums.RolNombre;
import com.example.demo.Security.repository.RolRepsoritory;

@Service
@Transactional
public class RolService {

	@Autowired
	RolRepsoritory rolRepository;
	
	public Optional<Rol> getByRolNombre(RolNombre rolNombre){
		return rolRepository.findByRolNombre(rolNombre);
	}
	
	public void save(Rol rol){
        rolRepository.save(rol); 
	}
}
