package cz.tjv.tjv.semestralkadto;

import java.io.Serializable;
import java.util.List;

public class AutorDTO implements Serializable {
    private long id;
    private String name;
    private List<KnihaDTO> knihy;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<KnihaDTO> getKnihy() {
        return knihy;
    }

    public void setKnihy(List<KnihaDTO> knihy) {
        this.knihy = knihy;
    }
}
