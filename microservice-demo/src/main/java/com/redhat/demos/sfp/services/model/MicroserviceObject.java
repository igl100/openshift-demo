package com.redhat.demos.sfp.services.model;

public class MicroserviceObject {

	private int idAtributo;
	private String atributo;
	
	
   public MicroserviceObject() {		
		this.atributo = null;
	}
	
	public MicroserviceObject(String atributo) {
		this.atributo = atributo;
	}
	
	public MicroserviceObject(int idAtributo ,String atributo) {
		this.idAtributo = idAtributo;
		this.atributo = atributo;
	}

	public String getAtributo() {
		return atributo;
	}

	public void setAtributo(String atributo) {
		this.atributo = atributo;
	}

	public int getIdAtributo() {
		return idAtributo;
	}

	public void setIdAtributo(int idAtributo) {
		this.idAtributo = idAtributo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((atributo == null) ? 0 : atributo.hashCode());
		result = prime * result + idAtributo;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MicroserviceObject other = (MicroserviceObject) obj;
		if (atributo == null) {
			if (other.atributo != null)
				return false;
		} else if (!atributo.equals(other.atributo))
			return false;
		if (idAtributo != other.idAtributo)
			return false;
		return true;
	}
	
}
