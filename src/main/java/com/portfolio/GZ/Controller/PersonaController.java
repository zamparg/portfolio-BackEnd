package com.portfolio.GZ.Controller;

import com.portfolio.GZ.Interface.IPersonaService;
import com.portfolio.GZ.entity.Persona;
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
public class PersonaController {
    @Autowired IPersonaService ipersonaService;

    @GetMapping("/personas/traer")
    public List<Persona> getPersona(){
    return ipersonaService.getPersona();
    }
    
    @GetMapping("/personas/traer/perfil")
    public Persona findPersona(){
        return ipersonaService.findPersona((long)2);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/personas/crear")
    public String createPersona(@RequestBody Persona persona){
        ipersonaService.savePersona(persona);
        return "La persona fue creada correctamente";
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/personas/borrar/{id}")
    public String deletePersona(@PathVariable Long id){
        ipersonaService.deletePersona(id);
        return "La persona fue eliminada con exito";
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/personas/editar/{id}")
    public Persona editPersona(@PathVariable Long id,@RequestBody Persona newPersona){
        Persona persona = ipersonaService.findPersona(id);
        persona.setName(newPersona.getName());
        persona.setDescription(newPersona.getDescription());
        persona.setAbout(newPersona.getAbout());
        persona.setImg(newPersona.getImg());
            
        ipersonaService.savePersona(persona);
        return persona;
    }
                                    
}
    



