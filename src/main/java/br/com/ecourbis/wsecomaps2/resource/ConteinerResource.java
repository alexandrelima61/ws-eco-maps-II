/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ecourbis.wsecomaps2.resource;

import br.com.ecourbis.wsecomaps2.controller.ConteinerController;
import br.com.ecourbis.wsecomaps2.model.Conteiner;
import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author jalima
 */
@Path("/conteiner")
public class ConteinerResource {

    @GET
    @Produces("application/json")
    @Path("/lstRang/{lt}/{lg}")
    public ArrayList<Conteiner> lstConteModel(@PathParam("lt") Double lat,
            @PathParam("lg") Double log) {
        Double raio = 0.02;
        return new ConteinerController().listaConteiner(lat, log, raio);
    }

    @GET
    @Produces("application/json")
    @Path("/lstRangRaio/{lt}/{lg}/{raio}")
    public ArrayList<Conteiner> lstConteModelRaio(@PathParam("lt") Double lat,
            @PathParam("lg") Double log, @PathParam("raio") Double raio) {
        return new ConteinerController().listaConteiner(lat, log, raio);
    }

}
