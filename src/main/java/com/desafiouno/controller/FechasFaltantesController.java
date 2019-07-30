package com.desafiouno.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafiouno.service.FechasFaltantesService;

@RestController
@RequestMapping("/periodos")
public class FechasFaltantesController {

	@Autowired
    private FechasFaltantesService fechaService;

    @GetMapping(value="/fechasFaltantes")
    public ResponseEntity<?> getFechasFaltantes(){
        try{
            return new ResponseEntity<>(fechaService.getFechasFaltantes(), HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>(e, HttpStatus.BAD_GATEWAY);
        }
    }
}