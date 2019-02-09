package cz.tjv.tjv.semestralka.entity;

import cz.tjv.tjv.semestralkadto.KnihaDTO;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="KNIHA")
public class Kniha implements Serializable {
    @Id
    @GeneratedValue
    private long id;
    
    private String name;
    
    @ManyToOne
    private Autor autor;
    
    @ManyToOne
    private Vydavatel vydavatel;
    
    public Kniha() {
        
    }
    
    public Kniha(KnihaDTO dto) {
        id        = dto.getId();
        name      = dto.getName();
        autor     = new Autor(dto.getAutor());
        vydavatel = new Vydavatel(dto.getVydavatel());
    }
    
    public KnihaDTO createDTO() {
        KnihaDTO result = new KnihaDTO();
        result.setId(id);
        result.setName(name);
        result.setAutor(autor.createDTO());
        result.setVydavatel(vydavatel.createDTO());
        return result;
    }

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

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Vydavatel getVydavatel() {
        return vydavatel;
    }

    public void setVydavatel(Vydavatel vydavatel) {
        this.vydavatel = vydavatel;
    }
}
