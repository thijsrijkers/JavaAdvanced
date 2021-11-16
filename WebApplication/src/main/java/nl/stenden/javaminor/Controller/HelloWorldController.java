package nl.stenden.javaminor.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/helloworld")
public class HelloWorldController {

    @GetMapping
    public String helloWorld(){
        System.out.println("hello");
        return "Hello World";
    }
}
