package com.Facundo.AdministracionDevs.controller;

import com.Facundo.AdministracionDevs.entity.Desarrollador;
import com.Facundo.AdministracionDevs.service.IDesarrolladorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/desarrolladores")
public class DesarrolladorController {
    @Autowired
    private IDesarrolladorService desarrolladorService;

    @GetMapping("/traer")
    public ResponseEntity<List<Desarrollador>> getAll(){
        try {
            List<Desarrollador> desarrolladores = this.desarrolladorService.getAll();
            return ResponseEntity.ok(desarrolladores);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping("/traer/{id}")
    public ResponseEntity<Desarrollador> GetDevById(@PathVariable Long id){
        try {
            Desarrollador desarrollador = this.desarrolladorService.findById(id);
            return ResponseEntity.ok(desarrollador);

        }catch (NoSuchElementException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

        }catch (Exception e){
            return  ResponseEntity.badRequest().body(null);
        }
    }

    @PostMapping("/crear")
    public ResponseEntity<?> save(@RequestBody Desarrollador desarrollador){
        try{
            this.desarrolladorService.save(desarrollador);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body("Desarrollador creado");

        }catch (Exception e){
            return ResponseEntity.badRequest()
                    .body("Ocurrio un error inesperado: " + e.getMessage());
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> deleteDevById(@PathVariable Long id){
        try{
            this.desarrolladorService.delete(id);
            return ResponseEntity.noContent().build();

        }catch(NoSuchElementException e){
            return ResponseEntity.notFound().build();

        }catch (Exception e){
            return ResponseEntity.badRequest()
                    .body("Error inesperado: " + e.getMessage());
        }
    }

    @PutMapping("/actualizar")
    public ResponseEntity<?> updateDev(@RequestBody Desarrollador desarrollador){
        try{
            this.desarrolladorService.update(desarrollador);
            return ResponseEntity.ok("Desarrollador actualizado con exito");
        }catch(NoSuchElementException e){
            return ResponseEntity.notFound().build();

        }catch (Exception e){
            return ResponseEntity.badRequest()
                    .body("Error inesperado: " + e.getMessage());
        }
    }
}
