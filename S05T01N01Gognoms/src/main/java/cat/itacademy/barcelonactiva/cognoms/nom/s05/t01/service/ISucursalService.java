package cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.service;

import java.util.List;
import java.util.Optional;


import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.model.domain.Sucursal;
import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.model.dto.SucursalDTO;

public interface ISucursalService {

	public SucursalDTO crearSucursal(SucursalDTO sucursalDTO);
	public List<SucursalDTO> findAll();
	public SucursalDTO findById(int id);
	public void delete(int id);
	public SucursalDTO actualizar(SucursalDTO sucursalDTO,int id);

}
