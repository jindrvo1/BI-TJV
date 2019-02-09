package cz.tjv.tjv.semestralka.entity;

import cz.tjv.tjv.semestralkadto.AutorDTO;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="AUTOR")
public class Autor implements Serializable {
    @Id
    @GeneratedValue
    private long id;
    
    private String name;
    
    @OneToMany(mappedBy = "autor")
    private List<Kniha> knihy;
    
    public Autor() {
        
    }
    
    public Autor(AutorDTO dto) {
        id   = dto.getId();
        name = dto.getName();
    }
    
    public AutorDTO createDTO() {
        AutorDTO result = new AutorDTO();
        result.setId(id);
        result.setName(name);
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

    public List<Kniha> getKnihy() {
        return knihy;
    }

    public void setKnihy(List<Kniha> knihy) {
        this.knihy = knihy;
    }
}
