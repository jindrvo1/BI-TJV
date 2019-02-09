package cz.tjv.tjv.semestralka.entity;

import cz.tjv.tjv.semestralkadto.VydavatelDTO;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="VYDAVATEL")
public class Vydavatel implements Serializable {
    @Id
    @GeneratedValue
    private long id;
    
    private String name;
    
    @OneToMany(mappedBy = "vydavatel")
    private List<Kniha> knihy;
    
    public Vydavatel() {
        
    }
    
    public Vydavatel(VydavatelDTO dto) {
        id   = dto.getId();
        name = dto.getName();
    } 
    
    public VydavatelDTO createDTO() {
        VydavatelDTO result = new VydavatelDTO();
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
