package com.patrick.vehiculosAPIRest.Business;

import com.patrick.vehiculosAPIRest.Entities.Vehiculo;
import com.patrick.vehiculosAPIRest.Repository.VehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehiculoBusiness {
    @Autowired
    private VehiculoRepository vehiculoRepository;

    public Vehiculo saveVehiculo(Vehiculo vehiculo){
        return vehiculoRepository.save(vehiculo);
    }

    public List<Vehiculo> getVehiculos(){
        return (List<Vehiculo>) vehiculoRepository.findAll();
    }

    public Vehiculo updateVehiculo(Long id, Vehiculo vehiculo){
        return vehiculoRepository.findById(id)
                .map(v -> {
                    v.setModelo(vehiculo.getModelo());
                    v.setAnio(vehiculo.getAnio());
                    v.setMarca(vehiculo.getMarca());
                    v.setPlaca(vehiculo.getPlaca());
                    return vehiculoRepository.save(v);
                })
                .orElse(null);
    }

    public Vehiculo deleteVehiculo(Long id){
        Vehiculo v = vehiculoRepository.findById(id).get();
        if(v != null){
            vehiculoRepository.delete(v);
        } else {
            return null;
        }
        return v;
    }
}
