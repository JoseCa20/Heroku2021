package com.example.demo.Security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Security.entity.Rol;
import com.example.demo.Security.enums.RolNombre;

@Repository
public interface RolRepsoritory extends JpaRepository<Rol, Integer>{
	
	Optional<Rol> findByRolNombre(RolNombre rolNombre);

}
