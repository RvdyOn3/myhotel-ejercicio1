package com.myhotel.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="mantenimiento")
public class Mantenimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MANTENIMIENTO_ID")
    @ApiModelProperty(hidden = true)
    private Integer mantenimientoId;
    @Column(name = "MANTENIMIENTO_DATE")
    private Date mantenimientoDate;
    @Column(name = "TOTAL")
    private BigDecimal total;
    @Column(name = "VEHICULO_ID")
    @ApiModelProperty(hidden = true)
    private Integer vehiculoId;
}
