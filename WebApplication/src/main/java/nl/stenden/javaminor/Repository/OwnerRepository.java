package nl.stenden.javaminor.Repository;

import nl.stenden.javaminor.Model.Owner;
import nl.stenden.javaminor.dto.OwnerDTO;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class OwnerRepository {

    @PersistenceContext
    private EntityManager manager;

    public List<Owner> getOwners(){
        TypedQuery<Owner> query = manager.createQuery("SELECT o FROM Owner o", Owner.class);
        return query.getResultList();
    }

    public List<Owner> getOwner(int id){
        TypedQuery<Owner> query = manager.createQuery("SELECT o FROM Owner o WHERE id = "+id, Owner.class);
        return query.getResultList();
    }

    @Transactional
    public Owner postOwner(Owner owner){
        manager.persist(owner);
        return manager.find(Owner.class, owner.getId());
    }

    @Transactional
    public void putOwner(Owner owner, int id){
        Owner update = manager.find(Owner.class, id);
        update.setName(owner.getName());
    }

    @Transactional
    public void deleteOwner(int id){
        Owner owner = manager.find(Owner.class, id);
        manager.remove(owner);
    }
}