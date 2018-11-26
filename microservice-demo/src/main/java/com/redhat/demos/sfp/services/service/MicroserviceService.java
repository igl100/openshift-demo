package com.redhat.demos.sfp.services.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import com.redhat.demos.sfp.services.model.MicroserviceObject;

@Stateless
public class MicroserviceService {
	
	private List<MicroserviceObject> listObjetos;
	
	public MicroserviceService(){
		this.listObjetos = new ArrayList<MicroserviceObject>();
		this.listObjetos.add(new MicroserviceObject(1, "uno"));
		this.listObjetos.add(new MicroserviceObject(2, "dos"));
		this.listObjetos.add(new MicroserviceObject(3, "tres"));
		this.listObjetos.add(new MicroserviceObject(4, "cuatro"));
	}
	
	public List<MicroserviceObject> getAllObjetoParaMicroservicio() {
		
		return this.listObjetos;
	}
	
	public MicroserviceObject getObjetoById(int idAtributo) {
		return this.listObjetos.stream().filter(a-> a.getIdAtributo() == idAtributo).findFirst().get();
	}
	
	public void addObjeto(MicroserviceObject objeto) {
		
		this.listObjetos.add(objeto);
	}
	
	public void deleteObjeto(int idObjeto) {
		MicroserviceObject objeto = this.getObjetoById(idObjeto);
		this.listObjetos.remove(objeto);
	}
	
	public void modifyObjeto(MicroserviceObject objeto) {
		MicroserviceObject objetoActual = this.getObjetoById(objeto.getIdAtributo());
		objetoActual.setAtributo(objeto.getAtributo());
	}
	

}