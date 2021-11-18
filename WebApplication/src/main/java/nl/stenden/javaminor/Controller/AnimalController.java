package nl.stenden.javaminor.Controller;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/animals")
public class AnimalController {

    private List<String> animals = Arrays.asList("hond", "kat");

    @GetMapping
    public String getAnimals(){
        return animals.toString();
    }

    @PostMapping
    public String postAnimals(){
        return animals.toString();
    }

    @PutMapping
    public String putAnimals(){
        return animals.toString();
    }

    @DeleteMapping
    public String deleteAnimals(){
        return animals.toString();
    }
}
