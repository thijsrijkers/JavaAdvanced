package nl.stenden.javaminor.Service;

import nl.stenden.javaminor.ConvertToDTO;
import nl.stenden.javaminor.Model.Owner;
import nl.stenden.javaminor.Repository.OwnerRepository;
import nl.stenden.javaminor.dto.AnimalDTO;
import nl.stenden.javaminor.dto.OwnerDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OwnerService {

    private final ConvertToDTO convertToDTO = new ConvertToDTO();

    private final OwnerRepository ownerRepository;

    public OwnerService(OwnerRepository ownerRepository){
        this.ownerRepository = ownerRepository;
    }

    public List<OwnerDTO> getOwners() {
        return ownerRepository.getOwners().stream().map(convertToDTO::toOwnerDto).collect(Collectors.toList());
    }

    public OwnerDTO getOwner(Integer id){
        return convertToDTO.toOwnerDto(ownerRepository.getOwner(id).get(0));
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
