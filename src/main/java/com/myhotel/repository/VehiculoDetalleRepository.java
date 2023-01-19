package com.myhotel.repository;

import com.myhotel.model.VehiculoDetalle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehiculoDetalleRepository extends JpaRepository<VehiculoDetalle, Integer> {
}
