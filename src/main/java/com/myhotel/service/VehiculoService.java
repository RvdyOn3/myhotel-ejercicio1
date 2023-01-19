package com.myhotel.service;

import com.myhotel.model.Vehiculo;

import java.util.List;

public interface VehiculoService {

    Vehiculo addVehiculo(Vehiculo vehiculo);
    Vehiculo getVehiculoById(Integer id);
    List<Vehiculo> getAllVehiculo();
    Vehiculo actualizar(Integer id, Vehiculo vehiculo);
    void eliminar(Integer id);
}
