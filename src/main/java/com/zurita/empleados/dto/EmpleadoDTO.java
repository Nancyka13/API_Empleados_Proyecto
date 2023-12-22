package com.zurita.empleados.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class EmpleadoDTO {
	private int id;
	private String nombre;
	private String dni;
	private String telefono;
}





