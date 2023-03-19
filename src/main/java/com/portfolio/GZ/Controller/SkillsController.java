package com.portfolio.GZ.Controller;

import com.portfolio.GZ.Interface.ISkillsService;
import com.portfolio.GZ.entity.Skills;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("skills")
@CrossOrigin(origins="http://localhost:4200")
public class SkillsController {
    @Autowired ISkillsService iskillsService;

    @GetMapping("/traer")
    public List<Skills> getSkills(){
    return iskillsService.getSkills();
    }
    
    @GetMapping("/traer/{id}")
    public Skills findSkills(@PathVariable Long id){
        return iskillsService.findSkills(id);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/crear")
    public String createSkills(@RequestBody Skills skills){
        iskillsService.saveSkills(skills);
        return "La skills fue creada correctamente";
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/borrar/{id}")
    public String deleteSkills(@PathVariable Long id){
        iskillsService.deleteSkills(id);
        return "La skills fue eliminada con exito";
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/editar/{id}")
    public Skills editSkills(@PathVariable Long id,@RequestBody Skills newSkills){
        Skills skills = iskillsService.findSkills(id);
        skills.setTittle(newSkills.getTittle());
        skills.setPercent(newSkills.getPercent());
        skills.setImg(newSkills.getImg());
       
        iskillsService.saveSkills(skills);
        return skills;
    }
                                    
}
    



