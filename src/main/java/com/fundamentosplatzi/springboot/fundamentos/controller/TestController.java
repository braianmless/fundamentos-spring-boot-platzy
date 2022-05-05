package com.fundamentosplatzi.springboot.fundamentos.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
    /*Para aceptar todas la solicitudes dentro de este metodo a traves de HTTP*/
    @RequestMapping
    /*Para responder un cuerpo a nivel del servicio*/
    @ResponseBody
    public ResponseEntity<String> function(){
        return new ResponseEntity<>("Hello from controller with change with change con f9", HttpStatus.OK);
    }

}
