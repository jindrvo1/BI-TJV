package cz.tjv.tjv.semestralka.rest;

import cz.tjv.tjv.semestralka.controller.KnihaController;
import cz.tjv.tjv.semestralka.entity.Kniha;
import cz.tjv.tjv.semestralkadto.KnihaDTO;
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
@Path("kniha")
public class KnihaREST {
    @EJB
    private KnihaController controller;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<KnihaDTO> getAll() {
        List<KnihaDTO> result = new ArrayList<>();
        for (Kniha k : controller.selectAll()) {
            result.add(k.createDTO());
        }
        
        return result;
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void createOrUpdate(KnihaDTO dto) {
        controller.createOrUpdate(new Kniha(dto));
    }
    
    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void delete(@PathParam("id") long id) {
        controller.delete(controller.selectById(id));
    }
}
