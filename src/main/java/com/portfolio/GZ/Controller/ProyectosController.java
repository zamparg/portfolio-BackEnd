package com.portfolio.GZ.Controller;

import com.portfolio.GZ.Interface.IProyectosService;
import com.portfolio.GZ.entity.Proyectos;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="https://portfolio-ap-zampar.web.app")
public class ProyectosController {
    @Autowired IProyectosService iproyectosService;

    @GetMapping("/proyectos/traer")
    public List<Proyectos> getProyectos(){
    return iproyectosService.getProyectos();
    }
    
    @GetMapping("/proyectos/traer/{id}")
    public Proyectos findProyectos(@PathVariable Long id){
        return iproyectosService.findProyectos(id);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/proyectos/crear")
    public String createProyectos(@RequestBody Proyectos proyectos){
        iproyectosService.saveProyectos(proyectos);
        return "La proyectos fue creada correctamente";
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/proyectos/borrar/{id}")
    public String deleteProyectos(@PathVariable Long id){
        iproyectosService.deleteProyectos(id);
        return "La proyectos fue eliminada con exito";
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/proyectos/editar/{id}")
    public Proyectos editProyectos(@PathVariable Long id,@RequestBody Proyectos newProyectos){
        Proyectos proyectos = iproyectosService.findProyectos(id);
        proyectos.setTittle(newProyectos.getTittle());
        proyectos.setDescription(newProyectos.getDescription());
        proyectos.setLink(newProyectos.getLink());
        proyectos.setImg(newProyectos.getImg());
       
        iproyectosService.saveProyectos(proyectos);
        return proyectos;
    }
                                    
}
    



