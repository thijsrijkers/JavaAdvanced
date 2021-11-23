package nl.stenden.javaminor.Repository;

import nl.stenden.javaminor.Model.Animal;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class AnimalRepository {

    @PersistenceContext
    private EntityManager manager;

    public List getAnimals(){
        TypedQuery<Animal> query = manager.createQuery("SELECT a FROM Animal a", Animal.class);
        return query.getResultList();
    }
}
