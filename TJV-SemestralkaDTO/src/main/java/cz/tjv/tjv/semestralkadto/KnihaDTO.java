package cz.tjv.tjv.semestralkadto;

import java.io.Serializable;

public class KnihaDTO implements Serializable {
    private long id;
    private String name;
    private AutorDTO autor;
    private VydavatelDTO vydavatel;

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

    public AutorDTO getAutor() {
        return autor;
    }

    public void setAutor(AutorDTO autor) {
        this.autor = autor;
    }

    public VydavatelDTO getVydavatel() {
        return vydavatel;
    }

    public void setVydavatel(VydavatelDTO vydavatel) {
        this.vydavatel = vydavatel;
    }
}
