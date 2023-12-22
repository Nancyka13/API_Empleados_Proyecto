package com.zurita.empleados.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zurita.empleados.converter.EmpleadoConverter;
import com.zurita.empleados.dto.EmpleadoDTO;
import com.zurita.empleados.entity.Empleado;
import com.zurita.empleados.service.EmpleadoService;

import java.util.List;


@RestController
@RequestMapping("/empleados")

public class EmpleadoController {
	@Autowired
	private EmpleadoService service;
	
	@Autowired
	private EmpleadoConverter converter;
	
	@GetMapping()
	public ResponseEntity<List<EmpleadoDTO>> findAll(
	        @RequestParam(value = "nombre", required = false, defaultValue = "") String nombre,
	        @RequestParam(value = "offset", required = false, defaultValue = "0") int pageNumber,
	        @RequestParam(value = "limit", required = false, defaultValue = "5") int pageSize
	) {
	    Pageable page = PageRequest.of(pageNumber, pageSize);
	    List<Empleado> empleados;
	    if (nombre == null) {
	        empleados = service.findAll(page);
	    } else {
	        empleados = service.findByNombre(nombre, page);
	    }
	    if (empleados.isEmpty()) {
	        return ResponseEntity.noContent().build();
	    }
	    List<EmpleadoDTO> empleadosDTO = converter.fromEntity(empleados);
		return ResponseEntity.ok(empleadosDTO);

	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<EmpleadoDTO> findById(@PathVariable("id") int id){
		Empleado empleado= service.findById(id);
		if(empleado==null) {
			return ResponseEntity.notFound().build();
		}
		EmpleadoDTO empleadoDTO=converter.fromEntity(empleado);
		return ResponseEntity.ok(empleadoDTO);
	}
	
	@PostMapping
	public ResponseEntity<EmpleadoDTO> create (@RequestBody EmpleadoDTO empleadoDTO){
		Empleado registro=service.save(converter.fromDTO(empleadoDTO));
		EmpleadoDTO registroDTO=converter.fromEntity(registro);
		return ResponseEntity.status(HttpStatus.CREATED).body(registroDTO);
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<EmpleadoDTO> update(@PathVariable("id") int id,@RequestBody EmpleadoDTO empleadoDTO){
		Empleado registro = service.update(converter.fromDTO(empleadoDTO));
		if (registro==null) {
			return ResponseEntity.notFound().build();
		}
		EmpleadoDTO registroDTO=converter.fromEntity(registro);
		return ResponseEntity.ok(registroDTO);
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<EmpleadoDTO> delete (@PathVariable("id") int id){
		service.delete(id);
		return ResponseEntity.ok(null);
	}
}

