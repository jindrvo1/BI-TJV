package cz.tjv.tjv.semestralka.controller;

import cz.tjv.tjv.semestralka.entity.Vydavatel;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class VydavatelController {
    @PersistenceContext
    private EntityManager em;
    
    public void createOrUpdate(Vydavatel v) {
        em.merge(v);
    }
    
    public List<Vydavatel> selectAll() {
        return em.createQuery("SELECT v FROM Vydavatel v", Vydavatel.class).getResultList();
    }
    
    public void delete(Vydavatel v) {
        em.remove(v);
    }
    
    public Vydavatel selectById(Long id) {
        return em.find(Vydavatel.class, id);
    }
}
