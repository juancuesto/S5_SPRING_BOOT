package cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.model.dto;

import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.model.domain.Sucursal;

public class SucursalDTO {
	
	private int pk_SucursalId;
	private String nomSucursal;
	private String paisSucursal;
	private String tipoSucursal;
	private String[] listaPaises= {"España","portugal","Francia","Alemania","Belgica","Paises Bajos","Irlanda","Grecia","Luxemburgo",
			"Estonia","Lituania","Bulgaria","Malta","Chipre","Croacia","Polonia","Hungria",
			"Republica checa","Suecia","Finlandia","Austria","Letonia"};
	public SucursalDTO(String nomSucursal, String paisSucursal) {
		super();
		this.nomSucursal = nomSucursal;
		this.paisSucursal = paisSucursal;
		for(int i=0;i<listaPaises.length;i++) {
			if(paisSucursal.equalsIgnoreCase(listaPaises[i])) {
				tipoSucursal="UE";
			}else {
				tipoSucursal="no_UE";
			}
		}
	}
	public SucursalDTO() {
		super();
		for(int i=0;i<listaPaises.length;i++) {
			if(paisSucursal.equalsIgnoreCase(listaPaises[i])) {
				tipoSucursal="UE";
			}else {
				tipoSucursal="no_UE";
			}
		}
		
	}
	public int getPk_SucursalId() {
		return pk_SucursalId;
	}
	public void setPk_SucursalId(int pk_SucursalId) {
		this.pk_SucursalId = pk_SucursalId;
	}
	public String getNomSucursal() {
		return nomSucursal;
	}
	public void setNomSucursal(String nomSucursal) {
		this.nomSucursal = nomSucursal;
	}
	public String getPaisSucursal() {
		return paisSucursal;
	}
	public void setPaisSucursal(String paisSucursal) {
		this.paisSucursal = paisSucursal;
	}
	public String getTipoSucursal() {
		return tipoSucursal;
	}
	public void setTipoSucursal(String tipoSucursal) {
		this.tipoSucursal = tipoSucursal;
	}
	public String[] getListaPaises() {
		return listaPaises;
	}
	public void setListaPaises(String[] listaPaises) {
		this.listaPaises = listaPaises;
	}

	
	

}
