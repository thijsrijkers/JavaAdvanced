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

//    @GetMapping("/{id}")
//    @ResponseBody
//    public ResponseEntity<Animal> getAnimal(@PathVariable("id") final Integer id){
//        return service.getAnimal(id);
//    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Void> postAnimal(@Valid @RequestBody Animal animalBody){
        service.create(animalBody);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> putAnimal(@PathVariable("id") final Integer id, @Valid @RequestBody Animal animalBody){
        service.update(animalBody, id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAnimal(@PathVariable("id") final Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
