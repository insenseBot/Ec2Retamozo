package com.retamozo.ec2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.lang.String;


@Controller
@RequestMapping(path = "/api/curso")
public class MainController {
    @Autowired
    private CursosRepository cursosRepository;

    @PostMapping(path = "/nuevo") 
    public @ResponseBody String addNewCurso(@RequestParam String name, @RequestParam int credito) {

        Cursos c = new Cursos();
        c.setNombre(name);
        c.setCredito(credito);
        cursosRepository.save(c);
        return "Saved";
    }

    @GetMapping(path = "/listar") 
    public @ResponseBody Iterable<Cursos> getAllCursos() {
        return cursosRepository.findAll();
    }

    @DeleteMapping(path = "/eliminar")
    public @ResponseBody String deleteCurso(@RequestParam Integer id) {
        Cursos cursos = cursosRepository.findById(id).orElse(null);
        if (cursos != null) {
            cursosRepository.delete(cursos);
            return "Deleted";
        }
        return "Not found";
    }

}