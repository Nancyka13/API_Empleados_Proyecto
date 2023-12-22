package com.zurita.empleados.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zurita.empleados.entity.Empleado;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {
	List<Empleado> findByNombreContaining(String texto, Pageable page);

	Empleado findByNombre(String texto);
	
}
