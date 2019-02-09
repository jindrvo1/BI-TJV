package cz.tjv.tjv.semestralka.controller;

import cz.tjv.tjv.semestralka.entity.Kniha;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class KnihaController {
    @PersistenceContext
    private EntityManager em;
    
    public void createOrUpdate(Kniha k) {
        em.merge(k);
    }
    
    public List<Kniha> selectAll() {
        return em.createQuery("SELECT k FROM Kniha k", Kniha.class).getResultList();
    }
    
    public void delete(Kniha k) {
        em.remove(k);
    }
    
    public Kniha selectById(Long id) {
        return em.find(Kniha.class, id);
    }
}
