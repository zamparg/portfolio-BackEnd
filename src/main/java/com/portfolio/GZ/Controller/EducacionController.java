package com.portfolio.GZ.Controller;

import com.portfolio.GZ.Dto.dtoEducacion;
import com.portfolio.GZ.Security.Controller.Mensaje;
import com.portfolio.GZ.Service.ImpEducacionService;
import com.portfolio.GZ.entity.Educacion;
import java.util.List;
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
@RequestMapping("educacion")
@CrossOrigin(origins="http://localhost:4200")
public class EducacionController {
    @Autowired 
    ImpEducacionService impEducacionService;

    @GetMapping("/lista")
    public ResponseEntity<List<Educacion>> list(){
    List<Educacion> list = impEducacionService.list();
    return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        if(!impEducacionService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        impEducacionService.delete(id);
        return new ResponseEntity(new Mensaje("Eliminado con Exito"), HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/crear")
    public ResponseEntity<?> create(@RequestBody dtoEducacion dtoEd){
        if(StringUtils.isBlank(dtoEd.getTittle()))
            return new ResponseEntity(new Mensaje("El título es obligatorio"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(dtoEd.getTime()))
            return new ResponseEntity(new Mensaje("El tiempo es obligatorio"), HttpStatus.BAD_REQUEST);    
        if(StringUtils.isBlank(dtoEd.getAcademy()))
            return new ResponseEntity(new Mensaje("La Academia es obligatoria"), HttpStatus.BAD_REQUEST);
        
        Educacion educacion = new Educacion(dtoEd.getTime(), dtoEd.getTittle(),dtoEd.getAcademy());
        impEducacionService.save(educacion);
        return new ResponseEntity(new Mensaje("educacion creada con Exito"),HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/editar/{id}")
     public ResponseEntity<?> update(@PathVariable("id") Long id,@RequestBody  dtoEducacion dtoEd){
        if(!impEducacionService.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(dtoEd.getTittle()))
            return new ResponseEntity(new Mensaje("El nombre es Obligatorio"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(dtoEd.getTime()))
            return new ResponseEntity(new Mensaje("El tiempo es obligatorio"), HttpStatus.BAD_REQUEST);    
        if(StringUtils.isBlank(dtoEd.getAcademy()))
            return new ResponseEntity(new Mensaje("La Academia es obligatoria"), HttpStatus.BAD_REQUEST);
        
        Educacion educacion = impEducacionService.getOne(id).get();
       
        educacion.setTime(dtoEd.getTime());
        educacion.setTittle(dtoEd.getTittle());
        educacion.setAcademy(dtoEd.getAcademy());

        impEducacionService.save(educacion);
        return new ResponseEntity(new Mensaje("Educacion Actualizada"), HttpStatus.OK);
    }
      
     @GetMapping("/detail/{id}")
    public ResponseEntity<Educacion> getById(@PathVariable("id") Long id){
        if(!impEducacionService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Educacion educacion = impEducacionService.getOne(id).get();
        return new ResponseEntity(educacion, HttpStatus.OK);
    }
}
    



