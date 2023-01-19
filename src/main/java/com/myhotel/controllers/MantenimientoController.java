package com.myhotel.controllers;

import com.myhotel.config.ResponseHandler;
import com.myhotel.model.Mantenimiento;
import com.myhotel.model.Vehiculo;
import com.myhotel.service.MantenimientoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mantenimiento")
public class MantenimientoController {

    @Autowired
    private MantenimientoService mantenimientoService;
    @ApiOperation(value = "Consulta de mantenimientos"
            ,notes = "Lista de mantenimientos de un vehículo")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK. El recurso se obtiene correctamente", response = Mantenimiento.class ),
            @ApiResponse(code = 204, message = "Sin contenido. No se encontraron resultados"),
            @ApiResponse(code = 400, message = "Bad Request.", response = String.class),
            @ApiResponse(code = 500, message = "Error en la ejecución del servicio") })
    @GetMapping(value = "/vehiculo/{id}")
    @ResponseBody
    ResponseEntity<Object> consultarId(@PathVariable Integer id){
        try {
            List<Mantenimiento> mantenimientos = mantenimientoService.getMantenimientoByVehiculo(id);
            if(mantenimientos == null || mantenimientos.isEmpty()){
                return ResponseHandler.generateResponse("No se encontraron resultados para el ID: " + id, HttpStatus.OK, null);
            } else {
                return ResponseHandler.generateResponse("Mantenimientos encontrados.", HttpStatus.OK, mantenimientos);
            }
        } catch (Exception e){
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }
    @ApiOperation(value = "Registrar mantenimiento"
            ,notes = "Registrar el mantenimiento del vehículo")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "CREATED. El recurso se registro correctamente", response = Mantenimiento.class ),
            @ApiResponse(code = 400, message = "Bad Request.", response = String.class),
            @ApiResponse(code = 500, message = "Error en la ejecución del servicio") })
    @PostMapping("/{id}")
    ResponseEntity<Object> agregar (@PathVariable Integer id, @RequestBody Mantenimiento mantenimiento){
        try {
            Mantenimiento result = mantenimientoService.agregar(id, mantenimiento);
            return ResponseHandler.generateResponse("Se registro el mantenimiento del vehiculo: " + id, HttpStatus.CREATED, result);
        } catch (Exception e){
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }
}
