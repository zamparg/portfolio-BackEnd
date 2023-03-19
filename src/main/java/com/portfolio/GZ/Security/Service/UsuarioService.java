
package com.portfolio.GZ.Security.Service;


import com.portfolio.GZ.Security.Entity.Usuario;
import com.portfolio.GZ.Security.Repository.iUsuarioRepository;
import jakarta.transaction.Transactional;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UsuarioService {
    @Autowired
    iUsuarioRepository iusuarioRepositoriy;
    
     public Optional<Usuario> getByNombreUsuario(String nombreUsuario){
        return iusuarioRepositoriy.findByNombreUsuario(nombreUsuario);}
    
     public boolean existByNombreUsuario(String nombreUsuario){
         return iusuarioRepositoriy.existsByNombreUsuario(nombreUsuario);
     }
     
          public boolean existByEmail(String email){
         return iusuarioRepositoriy.existsByEmail(email);
     }
    public void save(Usuario usuario){
        iusuarioRepositoriy.save(usuario);
    }
}
