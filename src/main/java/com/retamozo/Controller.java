package com.retamozo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/idat")
public class Controller {
    
    @GetMapping(path = "/")
    public String inicio(){
        return "SL78781161 - Retamozo Sanchez Bryan Hugo";
    }

    @GetMapping(path = "/codigo")
    public String codigo(){
        return "SL78781161";
    }

    @GetMapping(path = "/nombre-completo")
    public String nombre(){
        return "Retamozo Sanchez Bryan Hugo";
    }
}
