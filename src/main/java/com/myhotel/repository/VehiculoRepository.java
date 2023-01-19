package com.myhotel.repository;

import com.myhotel.model.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface VehiculoRepository extends JpaRepository<Vehiculo, Integer> {

}
