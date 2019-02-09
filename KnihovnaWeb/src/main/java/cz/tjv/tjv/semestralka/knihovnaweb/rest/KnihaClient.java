package cz.tjv.tjv.semestralka.knihovnaweb.rest;

import cz.tjv.tjv.semestralkadto.KnihaDTO;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class KnihaClient {
    public static final String CLIENT_WS_URL = "http://localhost:8080/TJV-Semestralka/webresources/kniha";
    private Client client = ClientBuilder.newClient();
    private WebTarget target = client.target(CLIENT_WS_URL);
    
    public void delete(long id) {
        target.path("" + id).request().delete();
    }
    
    public void createOrUpdate(KnihaDTO k) {
        target.request().put(Entity.json(k));
    }
    
    public KnihaDTO selectById(long id) {
        return target.path("" + id).request(MediaType.APPLICATION_XML).get(KnihaDTO.class);
    }
    
    public Collection<KnihaDTO> selectAll() {
        KnihaDTO[] kArr = target.request(MediaType.APPLICATION_JSON).get(KnihaDTO[].class);
        List<KnihaDTO> result = Arrays.asList(kArr);
        return result;
    }
}
