package com.myhotel.repository;

import com.myhotel.model.Mantenimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface MantenimientoRepository extends JpaRepository<Mantenimiento, Integer> {

    List<Mantenimiento> findByVehiculoId(Integer vehiculoId);
}
