package com.zurita.empleados.converter;

import org.springframework.stereotype.Component;

import com.zurita.empleados.dto.EmpleadoDTO;
import com.zurita.empleados.entity.Empleado;

@Component
public class EmpleadoConverter extends AbstractConverter<Empleado, EmpleadoDTO> {

	@Override
	public EmpleadoDTO fromEntity(Empleado entity) {
		if (entity==null)return null;
		return EmpleadoDTO.builder()
				.id(entity.getId())
				.nombre(entity.getNombre())
				.dni(entity.getDni())
				.telefono(entity.getTelefono())
				.build();
	}

	@Override
	public Empleado fromDTO(EmpleadoDTO dto) {
		if (dto==null)return null;
		return Empleado.builder()
				.id(dto.getId())
				.nombre(dto.getNombre())
				.dni(dto.getDni())
				.telefono(dto.getTelefono())
				.build();
	}


}
