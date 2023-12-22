package com.zurita.empleados.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.zurita.empleados.entity.Empleado;

public interface EmpleadoService {

	public List<Empleado>findAll(Pageable page);
	public List<Empleado> findByNombre(String nombre, Pageable page);
	public Empleado findById(int id);
	public Empleado save(Empleado empleado);
	public Empleado update(Empleado empleado);
	public void delete(int id);
	
}

	