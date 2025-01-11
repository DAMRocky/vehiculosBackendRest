package com.patrick.vehiculosAPIRest.Rest;

import com.patrick.vehiculosAPIRest.Business.VehiculoBusiness;
import com.patrick.vehiculosAPIRest.Entities.Vehiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api")
public class VehiculoRest {
    @Autowired
    private VehiculoBusiness vehiculoBusines;

    @PostMapping("/vehiculos/crear")
    public Vehiculo createVehiculo(@RequestBody Vehiculo vehiculo){
        try {
            return vehiculoBusines.saveVehiculo(vehiculo);
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"error al crear el dispositivo");
        }
    }

    @GetMapping("/vehiculos/listar")
    public List<Vehiculo> getVehiculos(){
        try {
            return vehiculoBusines.getVehiculos();
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"error al obtener vehiculos");
        }
    }

    @PutMapping ("/vehiculos/actualizar/{id}")
    public Vehiculo updateVehiculo(@PathVariable Long id, @RequestBody Vehiculo vehiculo){
        try {
          Vehiculo v = vehiculoBusines.updateVehiculo(id,vehiculo);
          if(v != null){
              return v;
          } else {
              throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Vehiculo no existe");
          }
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"error al actualizar vehiculo");
        }
    }

    @DeleteMapping("/vehiculos/eliminar/{id}")
    public Vehiculo deleteVehiculo(@PathVariable Long id){
        try{
            return vehiculoBusines.deleteVehiculo(id);
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"error al eliminar vehiculo");
        }
    }
}
