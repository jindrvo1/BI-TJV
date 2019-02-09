package cz.tjv.tjv.semestralka.knihovnaweb.rest;

import cz.tjv.tjv.semestralkadto.VydavatelDTO;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class VydavatelClient {
    public static final String CLIENT_WS_URL = "http://localhost:8080/TJV-Semestralka/webresources/vydavatel";
    private Client client = ClientBuilder.newClient();
    private WebTarget target = client.target(CLIENT_WS_URL);
    
    public void delete(long id) {
        target.path("" + id).request().delete();
    }
    
    public void createOrUpdate(VydavatelDTO v) {
        target.request().put(Entity.json(v));
    }
    
    public VydavatelDTO selectById(long id) {
        return target.path("" + id).request(MediaType.APPLICATION_XML).get(VydavatelDTO.class);
    }
    
    public Collection<VydavatelDTO> selectAll() {
        VydavatelDTO[] vArr = target.request(MediaType.APPLICATION_JSON).get(VydavatelDTO[].class);
        List<VydavatelDTO> result = Arrays.asList(vArr);
        return result;
    }
}
