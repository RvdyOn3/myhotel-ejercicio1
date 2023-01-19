package com.myhotel.service;

import com.myhotel.model.Mantenimiento;

import java.util.List;

public interface MantenimientoService {

    List<Mantenimiento> getMantenimientoByVehiculo(Integer id);
    Mantenimiento agregar(Integer id, Mantenimiento mantenimiento);
}
