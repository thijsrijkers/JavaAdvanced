package nl.stenden.javaminor.Controller;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/helloworld")
@ComponentScan(basePackages = "nl.stenden.javaminor")
public class HelloWorldController {

    @GetMapping()
    public String helloWorld(){
        return "Hello World";
    }
}
