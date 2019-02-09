package cz.tjv.tjv.semestralka.rest;

import cz.tjv.tjv.semestralka.controller.VydavatelController;
import cz.tjv.tjv.semestralka.entity.Vydavatel;
import cz.tjv.tjv.semestralkadto.VydavatelDTO;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Stateless
@Path("vydavatel")
public class VydavatelREST {
    @EJB
    private VydavatelController controller;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<VydavatelDTO> getAll() {
        List<VydavatelDTO> result = new ArrayList<>();
        for (Vydavatel v : controller.selectAll()) {
            result.add(v.createDTO());
        }
        
        return result;
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void createOrUpdate(VydavatelDTO dto) {
        controller.createOrUpdate(new Vydavatel(dto));
    }
    
    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void delete(@PathParam("id") long id) {
        controller.delete(controller.selectById(id));
    }
}
