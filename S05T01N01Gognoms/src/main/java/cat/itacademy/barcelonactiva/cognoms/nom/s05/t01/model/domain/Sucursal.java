package cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Sucursal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pk_SucursalId;
	@Column(length=50)
	private String nomSucursal;
	private String paisSucursal;
	
	public Sucursal(String nomSucursal, String paisSuursal) {
		super();
		this.nomSucursal = nomSucursal;
		this.paisSucursal = paisSuursal;
	}
	public Sucursal() {
		super();
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
	public String getPaisSuursal() {
		return paisSucursal;
	}
	public void setPaisSuursal(String paisSuursal) {
		this.paisSucursal = paisSuursal;
	}
	
	

}
