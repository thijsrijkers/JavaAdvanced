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

    @Transactional
    public Animal postAnimals(Animal animal){
        manager.persist(animal);
        return manager.find(Animal.class, animal.getId());
    }

    @Transactional
    public void putAnimals(Animal animal, int id){
        Animal update = manager.find(Animal.class, id);
        update.setName(animal.getName());
    }

    @Transactional
    public void deleteAnimals(int id){
        Animal animal = manager.find(Animal.class, id);
        manager.remove(animal);
    }
}
