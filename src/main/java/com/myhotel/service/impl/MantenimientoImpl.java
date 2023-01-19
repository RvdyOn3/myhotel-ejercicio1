package com.myhotel.service.impl;

import com.myhotel.model.Mantenimiento;
import com.myhotel.model.Vehiculo;
import com.myhotel.repository.MantenimientoRepository;
import com.myhotel.repository.VehiculoRepository;
import com.myhotel.service.MantenimientoService;
import com.myhotel.service.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MantenimientoImpl implements MantenimientoService {
    @Autowired
    private MantenimientoRepository mantenimientoRepository;
    @Autowired
    private VehiculoService vehiculoService;
    @Override
    public List<Mantenimiento> getMantenimientoByVehiculo(Integer id) {
        return mantenimientoRepository.findByVehiculoId(id);
    }

    @Override
    public Mantenimiento agregar(Integer id, Mantenimiento mantenimiento) {
        Vehiculo vehiculo = vehiculoService.getVehiculoById(id);
        Mantenimiento mantenimientoResult = new Mantenimiento();
        if(vehiculo != null){
            mantenimiento.setVehiculoId(id);
            mantenimientoResult = mantenimientoRepository.save(mantenimiento);
        }
        return mantenimientoResult;
    }
}
