package com.myhotel.service.impl;

import com.myhotel.config.ApplicationConfig;
import com.myhotel.model.Vehiculo;
import com.myhotel.model.VehiculoDetalle;
import com.myhotel.repository.VehiculoRepository;
import com.myhotel.service.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class VehiculoImpl implements VehiculoService {

    @Autowired
    private VehiculoRepository vehiculoRepository;
    @Autowired
    private ApplicationConfig applicationConfig;

    @Override
    @Transactional
    public Vehiculo addVehiculo(Vehiculo vehiculo) {
        VehiculoDetalle vehiculoDetalle = vehiculo.getVehiculoDetalle();
        vehiculoDetalle.setVehiculo(vehiculo);
        vehiculo.setVehiculoDetalle(vehiculoDetalle);
        return vehiculoRepository.save(vehiculo);
    }

    @Override
    public Vehiculo getVehiculoById(Integer id) {
        return vehiculoRepository.findById(id).orElse(null);
    }

    @Override
    public List<Vehiculo> getAllVehiculo() {
        return vehiculoRepository.findAll();
    }

    @Override
    public Vehiculo actualizar(Integer id, Vehiculo vehiculo) {
        Vehiculo vehiculoResult = getVehiculoById(id);
        if(vehiculoResult != null){
            vehiculoResult.setAnio(vehiculo.getAnio());
            vehiculoResult.setModelo(vehiculo.getModelo());
            vehiculoResult.setKilometraje(vehiculo.getKilometraje());
            vehiculoResult.setCilindrada(vehiculo.getCilindrada());

            vehiculoResult.getVehiculoDetalle().setVehiculoDetalleTipo(vehiculo.getVehiculoDetalle().getVehiculoDetalleTipo());
            vehiculoResult.getVehiculoDetalle().setTipo(vehiculo.getVehiculoDetalle().getTipo());
            vehiculoResult.getVehiculoDetalle().setPuerta(vehiculo.getVehiculoDetalle().getPuerta());
            vehiculoResult.getVehiculoDetalle().setPasajeros(vehiculo.getVehiculoDetalle().getPasajeros());
            vehiculoResult.getVehiculoDetalle().setCapacidadMaletero(vehiculo.getVehiculoDetalle().getCapacidadMaletero());
            vehiculoResult.getVehiculoDetalle().setCapacidadToneladas(vehiculo.getVehiculoDetalle().getCapacidadToneladas());
            vehiculoResult.getVehiculoDetalle().setEjes(vehiculo.getVehiculoDetalle().getEjes());

            vehiculoResult = vehiculoRepository.save(vehiculoResult);
        }
        return vehiculoResult;
    }

    @Override
    public void eliminar(Integer id) {
        vehiculoRepository.deleteById(id);
    }
}
