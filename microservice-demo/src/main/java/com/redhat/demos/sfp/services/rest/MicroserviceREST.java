package com.redhat.demos.sfp.services.rest;

import java.util.List;
import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.validation.Validator;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.redhat.demos.sfp.services.controller.MicroserviceController;
import com.redhat.demos.sfp.services.model.MicroserviceObject;

@Path("/")
@RequestScoped
public class MicroserviceREST {
	
	@Inject
    private Logger log;

    @Inject
    private Validator validator;
	
	@Inject
	private MicroserviceController controller;
	
	@POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public void addObjeto(MicroserviceObject objeto) {
		controller.addObjeto(objeto);
	}
	
	@DELETE
	@Path("/data/{id:[0-9][0-9]*}")
	public void removeObjeto(@PathParam("id") int id) {
		controller.removeObjeto(id);
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void modifyObjeto(MicroserviceObject objeto) {
		controller.modifyObjeto(objeto);
	}
	
	@GET
	@Path("/default")
	@Produces(MediaType.APPLICATION_JSON)
	public MicroserviceObject getObjetoParaMicroservicio() {
		MicroserviceObject objeto = new MicroserviceObject();
		objeto.setAtributo("valor atributo");
				
		return objeto;
	}
	
	@GET
	@Path("/data/{id:[0-9][0-9]*}")
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public MicroserviceObject getObjetoParaMicroservicio(@PathParam("id") int id ) {
		return controller.getObjetoParaMicroservicio(id);
	}
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
	@Path("/getall")
	public List<MicroserviceObject> getObjetoParaMicroservicios() {
		return controller.getObjetoParaMicroservicios();
	}
	
}
