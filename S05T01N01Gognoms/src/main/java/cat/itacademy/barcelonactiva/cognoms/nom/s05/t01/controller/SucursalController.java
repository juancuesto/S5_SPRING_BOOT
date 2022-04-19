package cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.model.domain.Sucursal;
import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.model.dto.SucursalDTO;
import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.service.ISucursalService;
import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.service.SucursalServiceImpl;
import ch.qos.logback.core.status.Status;

@RestController
@RequestMapping("/sucursal")
public class SucursalController {
	
	@Autowired
	private SucursalServiceImpl sucursalServicio;
	
	@PostMapping("/add")
	public ResponseEntity<SucursalDTO> guardarSucursal(@RequestBody SucursalDTO sucursalDTO){
		return new ResponseEntity<>(sucursalServicio.crearSucursal(sucursalDTO), HttpStatus.CREATED);
	}
	
	@GetMapping("/getAll")
	public List<SucursalDTO> listarSucursales(){
		return sucursalServicio.findAll();
	}
	
	@GetMapping("/getOne/{id}")
	public ResponseEntity<?> read(@PathVariable(value="id")int userId){
		SucursalDTO sucursal=sucursalServicio.findById(userId);
		
		return ResponseEntity.ok(sucursal);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable int id) {
		// TODO Auto-generated method stub
		SucursalDTO osucursal=sucursalServicio.findById(id);
		sucursalServicio.delete(id);
		return ResponseEntity.ok().build();	
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@RequestBody SucursalDTO sucursalDTO,@PathVariable(value="id")int userId){
		SucursalDTO sucursalActualizada=sucursalServicio.actualizar(sucursalDTO, userId);
		return new ResponseEntity<>(sucursalActualizada,HttpStatus.OK);
	}
}
