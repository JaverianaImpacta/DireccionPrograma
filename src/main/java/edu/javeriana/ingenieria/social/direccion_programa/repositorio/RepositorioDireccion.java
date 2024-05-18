package edu.javeriana.ingenieria.social.direccion_programa.repositorio;

import edu.javeriana.ingenieria.social.direccion_programa.dominio.Direccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioDireccion extends JpaRepository<Direccion, Integer> {
    List<Direccion> findAllByPrograma(Integer programa);

    Direccion findOneById(Integer id);
}
