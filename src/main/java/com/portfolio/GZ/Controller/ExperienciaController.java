
package com.portfolio.GZ.Controller;

import com.portfolio.GZ.Dto.dtoExperiencia;
import com.portfolio.GZ.Security.Controller.Mensaje;
import com.portfolio.GZ.Service.ImpExperienciaService;
import com.portfolio.GZ.entity.Experiencia;
import java.util.List;
import java.util.Optional;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("experiencia")
@CrossOrigin(origins="http://localhost:4200")
public class ExperienciaController {
    @Autowired ImpExperienciaService iexperienciaService;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Experiencia>> list(){
        List<Experiencia> list = iexperienciaService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/traer/{id}")
    public Optional<Experiencia> getExperiencia(@PathVariable Long id){
        return iexperienciaService.getExperiencia(id);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Experiencia> getById(@PathVariable("id") Long id){
        if(!iexperienciaService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Experiencia experiencia = iexperienciaService.getExperiencia(id).get();
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/crear")
    public ResponseEntity<?> create(@RequestBody dtoExperiencia dtoExp){
        if(StringUtils.isBlank(dtoExp.getRole()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(iexperienciaService.existsByRole(dtoExp.getRole()))
            return new ResponseEntity(new Mensaje("Esa experiencia existe"), HttpStatus.BAD_REQUEST);
        
        Experiencia experiencia = new Experiencia(dtoExp.getEmployer(), dtoExp.getImg(),dtoExp.getRole(), dtoExp.getDuration(),dtoExp.getTask());
        iexperienciaService.saveExperiencia(experiencia);
        return new ResponseEntity(new Mensaje("Experiencia creada con Exito"),HttpStatus.OK);
    }
       
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/editar/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id,@RequestBody  dtoExperiencia dtoExp){
        if(!iexperienciaService.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        if(iexperienciaService.existsByRole(dtoExp.getRole()) && iexperienciaService.getByRole(dtoExp.getRole()).get().getId()!=id)
            return new ResponseEntity(new Mensaje("La experiencia no existe"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(dtoExp.getRole()))
            return new ResponseEntity(new Mensaje("El nombre es Obligatorio"), HttpStatus.BAD_REQUEST);
        
        Experiencia experiencia = iexperienciaService.getExperiencia(id).get();
        
        
        experiencia.setEmployer(dtoExp.getEmployer());
        experiencia.setImg(dtoExp.getImg());
        experiencia.setRole(dtoExp.getRole());
        experiencia.setDuration(dtoExp.getDuration());
        experiencia.setTask(dtoExp.getTask());
        
        iexperienciaService.saveExperiencia(experiencia);
        return new ResponseEntity(new Mensaje("Experiencia Actualizada"), HttpStatus.OK);
    }
        
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
       if(!iexperienciaService.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);  
       
       
       iexperienciaService.deleteExperiencia(id);
       return new ResponseEntity(new Mensaje("La experiencia fue eliminada con exito"), HttpStatus.OK);
    }
    
  
                                    
}
    



