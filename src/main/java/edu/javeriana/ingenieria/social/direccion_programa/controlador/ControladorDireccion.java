package edu.javeriana.ingenieria.social.direccion_programa.controlador;

import edu.javeriana.ingenieria.social.direccion_programa.dominio.Direccion;
import edu.javeriana.ingenieria.social.direccion_programa.servicio.ServicioDireccion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/direcciones/programa")
@CrossOrigin(origins="http://localhost:4200")
public class ControladorDireccion {
    @Autowired
    private ServicioDireccion servicio;

    @GetMapping("listar")
    public List<Direccion> obtenerDirecciones() {
        return servicio.obtenerDirecciones();
    }
    @GetMapping("obtenerPrograma")
    public ResponseEntity<List<Direccion>> obtenerDirecciones(Integer programa) {
        if(programa == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if(servicio.obtenerDirecciones(programa).isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(servicio.obtenerDirecciones(programa), HttpStatus.OK);
    }
    @GetMapping("obtener")
    public ResponseEntity<Direccion> obtenerDireccion(Integer id) {
        if(id == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if(!servicio.direccionExiste(id)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(servicio.obtenerDireccion(id), HttpStatus.OK);
    }
}
