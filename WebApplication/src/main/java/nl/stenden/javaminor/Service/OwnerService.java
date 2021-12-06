package nl.stenden.javaminor.Service;

import nl.stenden.javaminor.Model.Owner;
import nl.stenden.javaminor.Repository.OwnerRepository;
import nl.stenden.javaminor.dto.OwnerDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerService {

    private final OwnerRepository ownerRepository;

    public OwnerService(OwnerRepository ownerRepository){
        this.ownerRepository = ownerRepository;
    }

    public List getOwners() {
        return ownerRepository.getOwners();
    }

    public List getOwner(Integer id){
        return ownerRepository.getOwner(id);
    }

    public void create(Owner owner){
        ownerRepository.postOwner(owner);
    }

    public void update(Owner ownerBody, Integer id){
        ownerRepository.putOwner(ownerBody, id);
    }

    public void delete(Integer id){
        ownerRepository.deleteOwner(id);
    }
}
