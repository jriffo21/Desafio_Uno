package com.desafiouno.service;

import java.time.LocalDate;

import com.desafiouno.model.FechasFaltantes;

public interface FechasFaltantesService {
	
	public FechasFaltantes getFechasFaltantes()throws Exception;
	
	public boolean fechaCreacion(LocalDate fechaCreacion, LocalDate fechaCreacion2)throws Exception;
		
	public boolean fechaFin(LocalDate fechaFin, LocalDate fechaFin2)throws Exception;
}