package nl.stenden.javaminor.Repository;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class AnimalRepository {

    @PersistenceContext
    private EntityManager manager;

    public List getAnimals(){
        Query query = manager.createQuery("SELECT a FROM Animal a");
        return query.getResultList();
    }
}
