package com.redhat.demos.sfp.services.controller;

import java.util.List;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import com.redhat.demos.sfp.services.model.MicroserviceObject;
import com.redhat.demos.sfp.services.service.MicroserviceService;

@Model
public class MicroserviceController {

	@Inject
	private MicroserviceService service;

	public void addObjeto(MicroserviceObject objeto) {
		this.service.addObjeto(objeto);
	}

	public void removeObjeto(int idAtributo) {
		this.service.deleteObjeto(idAtributo);
	}

	public void modifyObjeto(MicroserviceObject objeto) {
		this.service.modifyObjeto(objeto);
	}

	public MicroserviceObject getObjetoParaMicroservicio() {
		MicroserviceObject objeto = new MicroserviceObject();
		objeto.setAtributo("valor atributo");

		return objeto;
	}

	public MicroserviceObject getObjetoParaMicroservicio(int idAtributo) {
		return this.service.getObjetoById(idAtributo);
	}

	public List<MicroserviceObject> getObjetoParaMicroservicios() {
		return this.service.getAllObjetoParaMicroservicio();
	}

	public String MiWebMetodo() {
		return "Metodo responde";
	}

}
