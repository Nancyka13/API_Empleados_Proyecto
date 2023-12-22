package com.zurita.empleados.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zurita.empleados.Validator.EmpleadoValidator;
import com.zurita.empleados.entity.Empleado;
import com.zurita.empleados.repository.EmpleadoRepository;
import com.zurita.empleados.service.EmpleadoService;



@Service
public class EmpleadoServiceImpl implements EmpleadoService{
	@Autowired
	private EmpleadoRepository repository;


	
	@Override
	@Transactional(readOnly = true)
	public List<Empleado> findAll(Pageable page) {
	    try {

	        return repository.findAll(page).toList();
	    } catch (Exception e) {
	        return null;
	    }
	}



	@Override
	public List<Empleado> findByNombre(String nombre, Pageable page) {
		try {

	        return repository.findByNombreContaining(nombre, page);
	    } catch (Exception e) {
	        return null;
	    }
	}

	
	
	@Override
	public Empleado findById(int id) {
		try {
			Empleado registro = repository.findById(id).orElseThrow();
			return registro;
		
		} catch (Exception e) {
			return null;
		}
	}

	

	@Override
	public Empleado save(Empleado empleado) {
		try {
			//EmpleadoValidator.save(empleado);
			empleado.setActivo(true);
			Empleado registro=repository.save(empleado);
			return registro;
		} catch (Exception e) {
			return null;
		}
	}


	@Override
	public Empleado update(Empleado empleado) {
		try {
			//EmpleadoValidator.save(empleado);
			Empleado registro = repository.findById(empleado.getId()).orElseThrow();
			registro.setNombre(empleado.getNombre());
			registro.setDni(empleado.getDni());
			registro.setTelefono(empleado.getTelefono());
			repository.save(registro);
			return registro;
		
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public void delete(int id) {
		try {
			Empleado registro = repository.findById(id).orElseThrow();
			repository.delete(registro);

		} catch (Exception e) {
			
		}
		
	}








}
