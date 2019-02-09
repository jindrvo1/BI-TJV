package cz.tjv.tjv.semestralka.controller;

import cz.tjv.tjv.semestralka.entity.Autor;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class AutorController {
    @PersistenceContext
    private EntityManager em;
    
    public void createOrUpdate(Autor a) {
        em.merge(a);
    }
    
    public List<Autor> selectAll() {
        return em.createQuery("SELECT a FROM Autor a", Autor.class).getResultList();
    }
    
    public void delete(Autor a) {
        em.remove(a);
    }
    
    public Autor selectById(Long id) {
        return em.find(Autor.class, id);
    }
}
