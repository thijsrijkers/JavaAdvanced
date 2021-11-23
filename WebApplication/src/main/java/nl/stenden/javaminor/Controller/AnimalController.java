package nl.stenden.javaminor.Controller;

import nl.stenden.javaminor.Model.Animal;
import nl.stenden.javaminor.Service.AnimalService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/animals")
public class AnimalController {

    private final AnimalService service;

    public AnimalController(AnimalService animalService) {
        this.service = animalService;
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<Animal>> getAnimals(){
        return ResponseEntity.ok(service.getAnimals());
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Animal> getAnimal(@PathVariable("id") final Integer id){
        return service.getAnimal(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity.BodyBuilder postAnimal(@Valid @RequestBody Animal animalBody){
        return service.create(animalBody);
    }

    @PutMapping("/{id}")
    public ResponseEntity.BodyBuilder putAnimal(@PathVariable("id") final Integer id, @Valid @RequestBody Animal animalBody){
        return service.update(animalBody, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity.BodyBuilder deleteAnimal(@PathVariable("id") final Integer id){
        return service.delete(id);
    }
}
