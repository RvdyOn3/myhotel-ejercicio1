package com.myhotel.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="vehiculo")
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "VEHICULO_ID")
    @ApiModelProperty(hidden = true)
    private Integer vehiculoId;
    @Column(name = "MARCA")
    @ApiModelProperty(required = true)
    private String marca;
    @Column(name = "MODELO")
    @ApiModelProperty(required = true)
    private String modelo;
    @Column(name = "PATENTE")
    @ApiModelProperty(required = true)
    @NotEmpty
    private String patente;
    @Column(name = "ANIO")
    @ApiModelProperty(required = true)
    private String anio;
    @Column(name = "KILOMETRAJE")
    @ApiModelProperty(required = true)
    private BigDecimal kilometraje;
    @Column(name = "CILINDRADA")
    @ApiModelProperty(required = true)
    private BigDecimal cilindrada;
    @OneToOne(mappedBy = "vehiculo",cascade = CascadeType.ALL)
    private VehiculoDetalle vehiculoDetalle;
}
