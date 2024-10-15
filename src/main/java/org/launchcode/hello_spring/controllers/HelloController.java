package org.launchcode.hello_spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class HelloController {

    // Responds to GET request at http://localhost:8080/goodbye
    @GetMapping("goodbye")
    @ResponseBody
    public String goodbye() {
        return "Goodbye, Spring!";
    }


    // Responds to GET and POST requests at http://localhost:8080/hello?name=LaunchCode
    // Handles request of the form
    @RequestMapping (method = {RequestMethod.GET, RequestMethod.POST}, value="hello")
    public String helloWithQueryParam(@RequestParam String name, Model model) {

        String theGreeting = "Hello, " + name + "!";
        model.addAttribute("greeting", theGreeting);

        return "hello";
    }




    /**** @PathParam Examples ****/

    // Handles request of the form
    // Responds to http://localhost:8080/hello/LaunchCode
    @GetMapping("hello/{name}")
    @ResponseBody
    public String helloWithPathParam(@PathVariable String name) {
        return "Hello, " + name + "!";
    }




    /**** Forms Examples ****/

    // Responds to http://localhost:8080/form
    @GetMapping("form")
    public String helloForm() {
        return "form";
    }


    // CT created - TEST example to answer Check Your Understanding #3
    // Responds to http://localhost:8080/test/name
    @GetMapping("test/{name}")
    public String testNamePrice(@PathVariable String name, Model model) {

        model.addAttribute("name", name);

        return "test";
    }

}
