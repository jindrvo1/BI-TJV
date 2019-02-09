package cz.tjv.tjv.semestralka.knihovnaweb.rest;

import cz.tjv.tjv.semestralkadto.AutorDTO;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class AutorClient {
    public static final String CLIENT_WS_URL = "http://localhost:8080/TJV-Semestralka/webresources/autor";
    private Client client = ClientBuilder.newClient();
    private WebTarget target = client.target(CLIENT_WS_URL);
    
    public void delete(long id) {
        target.path("" + id).request().delete();
    }
    
    public void createOrUpdate(AutorDTO a) {
        target.request().put(Entity.json(a));
    }
    
    public AutorDTO selectById(long id) {
        return target.path("" + id).request(MediaType.APPLICATION_XML).get(AutorDTO.class);
    }
    
    public Collection<AutorDTO> selectAll() {
        AutorDTO[] aArr = target.request(MediaType.APPLICATION_JSON).get(AutorDTO[].class);
        List<AutorDTO> result = Arrays.asList(aArr);
        return result;
    }
}
