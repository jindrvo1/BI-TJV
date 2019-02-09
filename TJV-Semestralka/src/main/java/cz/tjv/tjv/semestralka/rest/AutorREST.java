package cz.tjv.tjv.semestralka.rest;

import cz.tjv.tjv.semestralka.controller.AutorController;
import cz.tjv.tjv.semestralka.entity.Autor;
import cz.tjv.tjv.semestralkadto.AutorDTO;
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
@Path("autor")
public class AutorREST {
    @EJB
    private AutorController controller;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<AutorDTO> getAll() {
        List<AutorDTO> result = new ArrayList<>();
        for (Autor a : controller.selectAll()) {
            result.add(a.createDTO());
        }
        
        return result;
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void createOrUpdate(AutorDTO dto) {
        controller.createOrUpdate(new Autor(dto));
    }
    
    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void delete(@PathParam("id") long id) {
        controller.delete(controller.selectById(id));
    }
}
