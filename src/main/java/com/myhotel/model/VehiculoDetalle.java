package com.myhotel.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="vehiculo_detalle")
public class VehiculoDetalle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "VEHICULO_DETALLE_ID")
    @ApiModelProperty(hidden = true)
    private Integer vehiculoDetalleId;
    @Column(name = "VEHICULO_DETALLE_TIPO")
    private String vehiculoDetalleTipo;
    @Column(name = "TIPO")
    @ApiModelProperty(required = true)
    private String tipo;
    @Column(name = "PUERTA")
    private Integer puerta;
    @Column(name = "PASAJEROS")
    private Integer pasajeros;
    @Column(name = "CAPACIDAD_MALETERO")
    private BigDecimal capacidadMaletero;
    @Column(name = "CAPACIDAD_TONELADAS")
    private BigDecimal capacidadToneladas;
    @Column(name = "EJES")
    private Integer ejes;
    @OneToOne(cascade = CascadeType.ALL)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Vehiculo vehiculo;
}
