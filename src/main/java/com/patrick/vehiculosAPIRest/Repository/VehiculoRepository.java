package com.patrick.vehiculosAPIRest.Repository;

import com.patrick.vehiculosAPIRest.Entities.Vehiculo;
import org.springframework.data.repository.CrudRepository;

public interface VehiculoRepository extends CrudRepository<Vehiculo,Long> {
}
