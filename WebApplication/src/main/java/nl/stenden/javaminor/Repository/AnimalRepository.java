package nl.stenden.javaminor.Repository;

import nl.stenden.javaminor.Model.Animal;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class AnimalRepository {

    @PersistenceContext
    private EntityManager manager;

    public List<Animal> getAnimals(){
        TypedQuery<Animal> query = manager.createQuery("SELECT a FROM Animal a", Animal.class);
        return query.getResultList();
    }

    public List<Animal> getAnimal(int id){
        TypedQuery<Animal> query = manager.createQuery("SELECT a FROM Animal a WHERE id = "+id, Animal.class);
        return query.getResultList();
    }

    public List<Animal> postAnimals(Animal animal){
        TypedQuery<Animal> query = manager.createQuery("INSERT INTO Animal (name) VALUES ("+animal.getName()+")", Animal.class);
        return query.getResultList();
    }

    public List<Animal> putAnimals(){
        TypedQuery<Animal> query = manager.createQuery("SELECT a FROM Animal a", Animal.class);
        return query.getResultList();
    }

    public void deleteAnimals(int id){
        Query query = manager.createNativeQuery("DELETE FROM Animal AS a WHERE a.id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }
}
