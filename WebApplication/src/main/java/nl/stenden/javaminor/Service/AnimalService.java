package nl.stenden.javaminor.Service;

import nl.stenden.javaminor.ConvertToDTO;
import nl.stenden.javaminor.Model.Animal;
import nl.stenden.javaminor.Repository.AnimalRepository;
import nl.stenden.javaminor.dto.AnimalDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnimalService {

    private final ConvertToDTO convertToDTO = new ConvertToDTO();

    private final AnimalRepository animalRepository;

    public AnimalService(AnimalRepository animalRepository){
        this.animalRepository = animalRepository;
    }

    public List<AnimalDTO>  getAnimals() {
        return animalRepository.getAnimals().stream().map(convertToDTO::toAnimalDto).collect(Collectors.toList());
    }

    public AnimalDTO getAnimal(Integer id){
        return convertToDTO.toAnimalDto(animalRepository.getAnimal(id).get(0));
    }

    public void create(Animal animal){
        animalRepository.postAnimal(animal);
    }

    public void update(Animal animalBody, Integer id){
        animalRepository.putAnimal(animalBody, id);
    }

    public void delete(Integer id){
        animalRepository.deleteAnimal(id);
    }
}
