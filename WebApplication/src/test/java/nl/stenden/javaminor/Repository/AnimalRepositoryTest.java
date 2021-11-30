package nl.stenden.javaminor.Repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import nl.stenden.javaminor.Model.Animal;
import nl.stenden.javaminor.Model.Owner;
import nl.stenden.javaminor.config.TestApplicationConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = TestApplicationConfig.class)
@Transactional
public class AnimalRepositoryTest {

    @Autowired
    private AnimalRepository animalRepository;

    private Owner ownerTemp;
    private Animal animalTemp;

    @BeforeEach
    void setUp() {
        this.ownerTemp = new Owner();
        ownerTemp.setId(3);
        ownerTemp.setName("TobiasVanArkelen");

        this.animalTemp = new Animal();
        animalTemp.setName("Dino");
        animalTemp.setOwner(ownerTemp);
    }

    @Test
    @DisplayName("Testing if getAnimals() returns a list of animals")
    public void testMethodGetAnimals() {
        List<Animal> animals = animalRepository.getAnimals();
        assertNotNull(animals);
    }

    @Test
    @DisplayName("Testing if getAnimal retrieves the right animal")
    public void testMethodGetAnimal() {
        List<Animal> animal = animalRepository.getAnimal(1);
        assertEquals("cat", animal.get(0).getName());
    }

    @Test
    @DisplayName("Testing if postAnimal has posted the right animal")
    public void testMethodPostAnimal() {
        Animal animal = animalRepository.postAnimal(this.animalTemp);
        assertEquals("Dino", animal.getName());
    }

    @Test
    @DisplayName("Testing if putAnimal changed the entry")
    public void testMethodPutAnimal() {
        animalRepository.putAnimal(this.animalTemp, 1);
        List<Animal> animal = animalRepository.getAnimal(1);
        assertEquals("Dino", animal.get(0).getName());
    }

    @Test
    @DisplayName("Testing if deleteAnimal works")
    public void testMethodDeleteAnimal() {
        animalRepository.deleteAnimal(1);
    }

}
