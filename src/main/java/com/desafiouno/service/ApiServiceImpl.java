package com.desafiouno.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.desafiouno.model.FechasFaltantes;
import org.springframework.web.client.RestTemplate;

/**
*
* @author Jorge Riffo G.
*/
@Service
public class ApiServiceImpl implements ApiService {

	@Value("${rest.api.periodos}")
    private String url;

	/**
     * Metodo que retorna un objeto de fechas, que se obtiene desde la api periodos.
     *
     * @return FechasFaltantes
     */
    @Override
    public FechasFaltantes getApiFechas() throws Exception{
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, FechasFaltantes.class);
    }
}