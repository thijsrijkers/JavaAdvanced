package nl.stenden.javaminor.Controller;

import nl.stenden.javaminor.Model.Owner;
import nl.stenden.javaminor.Service.OwnerService;
import nl.stenden.javaminor.dto.OwnerDTO;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/owners")
public class OwnerController {

    private final OwnerService service;

    public OwnerController(OwnerService ownerService) {
        this.service = ownerService;
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<Owner>> getOwners(){
        return ResponseEntity.ok(service.getOwners());
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<List<Owner>> getOwner(@PathVariable("id") final Integer id){
        return ResponseEntity.ok(service.getOwner(id));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Void> postOwner(@Valid @RequestBody Owner ownerBody){
        service.create(ownerBody);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> putOwner(@PathVariable("id") final Integer id, @Valid @RequestBody Owner ownerBody){
        service.update(ownerBody, id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOwner(@PathVariable("id") final Integer id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}