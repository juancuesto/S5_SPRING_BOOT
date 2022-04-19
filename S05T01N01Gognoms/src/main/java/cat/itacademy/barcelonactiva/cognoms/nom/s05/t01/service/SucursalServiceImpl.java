package cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.model.domain.Sucursal;
import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.model.dto.SucursalDTO;
import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.repository.ISucursalRepository;

@Service
public class SucursalServiceImpl implements ISucursalService {
	
	@Autowired
	private ISucursalRepository sucursalRepo;

	@Override
	public SucursalDTO crearSucursal(SucursalDTO sucursalDTO) {
		// convertimos de DTO a Entidad
		
		Sucursal sucursal=new Sucursal();
		
		sucursal.setNomSucursal(sucursalDTO.getNomSucursal());
		sucursal.setPaisSuursal(sucursalDTO.getPaisSucursal());
		
		Sucursal nuevaSucursal=sucursalRepo.save(sucursal);
		
		// convertimos de Entidad a DTO
		
		SucursalDTO sucursalRespuesta=new SucursalDTO();
		
		sucursalRespuesta.setPk_SucursalId(nuevaSucursal.getPk_SucursalId());
		sucursalRespuesta.setNomSucursal(nuevaSucursal.getNomSucursal());
		sucursalRespuesta.setPaisSucursal(nuevaSucursal.getPaisSuursal());
		
		return sucursalRespuesta;
	}

	@Override
	public List<SucursalDTO> findAll() {
		List<Sucursal> sucursales=sucursalRepo.findAll();
		return sucursales.stream().map(new Function<Sucursal, SucursalDTO>() {
			@Override
			public SucursalDTO apply(Sucursal sucursal) {
				return mapearDTO(sucursal);
			}
		}).collect(Collectors.toList());		
	}

	@Override
	public SucursalDTO findById(int id) {
		Optional<Sucursal> osucursal=sucursalRepo.findById(id);
		Sucursal sucursal=osucursal.get();
		return mapearDTO(sucursal);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		sucursalRepo.deleteById(id);
	}
	
	
	public SucursalDTO actualizar(SucursalDTO sucursalDTO, int id) {
		// TODO Auto-generated method stub
		Optional<Sucursal> osucursal=sucursalRepo.findById(id);
		Sucursal sucursal=osucursal.get();
		sucursal=mapearEntidad(sucursalDTO);
		sucursalRepo.save(sucursal);
		
		return sucursalDTO;
	}
	
	//Convertimos  Entidad a DTO
	private SucursalDTO mapearDTO(Sucursal sucursal) {
		SucursalDTO sucursalDTO=new SucursalDTO();
		
		sucursalDTO.setPk_SucursalId(sucursal.getPk_SucursalId());
		sucursalDTO.setNomSucursal(sucursal.getNomSucursal());
		sucursalDTO.setPaisSucursal(sucursal.getPaisSuursal());
		
		return sucursalDTO;
	}

	//Convierte de DTO a Entidad
	private Sucursal mapearEntidad(SucursalDTO sucursalDTO) {
		Sucursal sucursal=new Sucursal();
		
		//sucursal.setPk_SucursalId(sucursalDTO.getPk_SucursalId());(en este caso no pasamos el ID)
		sucursal.setNomSucursal(sucursalDTO.getNomSucursal());
		sucursal.setPaisSuursal(sucursalDTO.getPaisSucursal());
		
		return sucursal;
	}

	
	
}
