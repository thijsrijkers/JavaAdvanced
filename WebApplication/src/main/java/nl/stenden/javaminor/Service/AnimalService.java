package nl.stenden.javaminor.Service;

import nl.stenden.javaminor.Model.Animal;

import java.util.List;

@Service
public class AnimalService {

    private List<Animal> animals;

    public AnimalService(){
        animals.add(new Animal(0,"dog"));
        animals.add(new Animal(1,"cat"));
        animals.add(new Animal(2,"hamster"));
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void create(Animal animal){
        animals.add(new Animal(animals.get(animals.size()-1).getId() +1 ,animal.getName()));
    }

    public void update(Animal animalBody, Integer id){
        for (Animal animal : animals) {
            if (animal.getId() == id) {
                animal.setName(animalBody.getName());
                break;
            }
        }
    }

    public void delete(Integer id){
        for (Animal animal : animals) {
            if (animal.getId() == id){
                animals.remove(animal);
                break;
            }
        }

    }
}
