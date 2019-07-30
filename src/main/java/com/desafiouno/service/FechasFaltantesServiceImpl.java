package com.desafiouno.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafiouno.model.FechasFaltantes;
import com.desafiouno.service.ApiService;

/**
*
* @author Jorge Riffo G.
*/
@Service
public class FechasFaltantesServiceImpl implements FechasFaltantesService {
		
	@Autowired
	private ApiService apiService;

	/**
     * Metodo que retorna un objeto con las fechas faltantes.
     *
     * @return FechasFaltantes
     */
	@Override
    public FechasFaltantes getFechasFaltantes() throws Exception{
        FechasFaltantes fechas = apiService.getApiFechas();
        List<LocalDate> listLocalDate = new ArrayList<>();        
        if(fechas != null){
            for(int i = fechas.getFechaCreacion().getYear(); i <= fechas.getFechaFin().getYear(); i++){
                for(int j = 1; j <= 12; j++){
                    if(fechaCreacion(LocalDate.of(i,j,1), fechas.getFechaCreacion()) &&
                       fechaFin(LocalDate.of(i,j,1), fechas.getFechaFin()) &&
                       ! fechas.getFechas().contains(LocalDate.of(i,j,1))){
                    	listLocalDate.add(LocalDate.of(i,j,1));
                    }
                }
            }
            fechas.setFechasFaltantes(listLocalDate);
        }
        return fechas;
    }

	/**
     * Metodo que retorna un true/false,si la fecha ingresada es posterior o igual
     * a la fecha especificada.
     *
     * @return boolean
     */
	@Override
	public boolean fechaCreacion(LocalDate fechaCreacion, LocalDate fechaCreacion2) throws Exception{
		return fechaCreacion.isAfter(fechaCreacion2) || fechaCreacion.isEqual(fechaCreacion2);
	}

	/**
     * Metodo que retorna un true/false,si la fecha ingresada es anterior o igual
     * a la fecha especificada,
     * 
     * @return boolean
     */
	@Override
	public boolean fechaFin(LocalDate fechaFin, LocalDate fechaFin2) throws Exception{
		return fechaFin.isBefore(fechaFin2) || fechaFin.isEqual(fechaFin2);
	}
}