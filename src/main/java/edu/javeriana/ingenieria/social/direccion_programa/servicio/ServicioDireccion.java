package edu.javeriana.ingenieria.social.direccion_programa.servicio;

import edu.javeriana.ingenieria.social.direccion_programa.dominio.Direccion;
import edu.javeriana.ingenieria.social.direccion_programa.repositorio.RepositorioDireccion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioDireccion{
    @Autowired
    private RepositorioDireccion repositorio;

    public List<Direccion> obtenerDirecciones(){
        return repositorio.findAll();
    }

    public List<Direccion> obtenerDirecciones(Integer programa){
        return repositorio.findAllByPrograma(programa);
    }

    public Direccion obtenerDireccion(Integer id){
        return repositorio.findOneById(id);
    }

    public boolean direccionExiste(Integer id){
        return repositorio.existsById(id);
    }
}
