package com.myhotel.controllers;

import com.myhotel.config.ResponseHandler;
import com.myhotel.model.Vehiculo;
import com.myhotel.service.VehiculoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehiculo")
public class VehiculoController {
    @Autowired
    private VehiculoService vehiculoService;
    @ApiOperation(value = "Listar todos"
            ,notes = "Listado de todos los vehículos")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK. El recurso se obtiene correctamente", response = Vehiculo.class ),
            @ApiResponse(code = 400, message = "Bad Request.", response = String.class),
            @ApiResponse(code = 500, message = "Error en la ejecución del servicio") })
    @GetMapping()
    @ResponseBody
    ResponseEntity<Object> todos(){
        try{
            List<Vehiculo> vehiculos = vehiculoService.getAllVehiculo();
            if(vehiculos == null || vehiculos.isEmpty()){
                return ResponseHandler.generateResponse("No se encontraron resultados. ", HttpStatus.OK, null);
            } else {
                return ResponseHandler.generateResponse("Listado de vehiculos encontrados.", HttpStatus.OK, vehiculos);
            }
        } catch (Exception e){
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }
    @ApiOperation(value = "Consulta de un solo vehículo"
            ,notes = "Obtener el registro de un vehículo por ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK. El recurso se obtiene correctamente", response = Vehiculo.class ),
            @ApiResponse(code = 400, message = "Bad Request.", response = String.class),
            @ApiResponse(code = 500, message = "Error en la ejecución del servicio") })
    @GetMapping(value = "/{id}")
    @ResponseBody
    ResponseEntity<Object> consultarId(@PathVariable Integer id){
        try{
            Vehiculo vehiculo = vehiculoService.getVehiculoById(id);
            if(vehiculo == null){
                return ResponseHandler.generateResponse("No se encontraron resultados para el vehiculo " + id, HttpStatus.OK, null);
            } else {
                return ResponseHandler.generateResponse("Se encontraron resultados para el vehiculo " + id, HttpStatus.OK, vehiculo);
            }
        } catch (Exception e){
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }
    @ApiOperation(value = "Registrar un vehículo"
            ,notes = "Registro completo de un vehículo")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "CREATED. El recurso se registro correctamente", response = Vehiculo.class ),
            @ApiResponse(code = 400, message = "Bad Request.", response = String.class),
            @ApiResponse(code = 500, message = "Error en la ejecución del servicio") })
    @PostMapping
    ResponseEntity<Object> agregar (@RequestBody Vehiculo vehiculo){
        try {
            Vehiculo result = vehiculoService.addVehiculo(vehiculo);
            return ResponseHandler.generateResponse("Se registro el vehiculo " + result.getVehiculoId() + " correctamente.", HttpStatus.CREATED, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }
    @ApiOperation(value = "Actualizar un vehículo"
            ,notes = "Actualizar el registro de un vehículo por ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK. El recurso actualizado correctamente", response = Vehiculo.class ),
            @ApiResponse(code = 400, message = "Bad Request.", response = String.class),
            @ApiResponse(code = 500, message = "Error en la ejecución del servicio") })
    @PutMapping(value = "/{id}")
    ResponseEntity<Object> update(@PathVariable Integer id, @RequestBody Vehiculo vehiculo){
        try{
            Vehiculo result = vehiculoService.actualizar(id, vehiculo);
            return ResponseHandler.generateResponse("Se actualizó el vehiculo " + id + " correctamente.", HttpStatus.OK, result);
        } catch (Exception e){
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }
    @ApiOperation(value = "Eliminar un vehículo"
            ,notes = "Eliminar el registro de un vehículo por ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK. El recurso eliminado correctamente", response = Vehiculo.class ),
            @ApiResponse(code = 400, message = "Bad Request.", response = String.class),
            @ApiResponse(code = 500, message = "Error en la ejecución del servicio") })
    @DeleteMapping(value = "{id}")
    ResponseEntity<Object> eliminar(@PathVariable Integer id){
        try {
            vehiculoService.eliminar(id);
            return ResponseHandler.generateResponse("Se eliminó el vehiculo " + id + " correctamente.", HttpStatus.OK, null);
        } catch (Exception e){
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

}
