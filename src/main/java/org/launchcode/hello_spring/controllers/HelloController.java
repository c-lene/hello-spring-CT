package org.launchcode.hello_spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class HelloController {

    // Handles request at path /hello
//    @GetMapping("hello")                                     // Tells SpringBoot that this method will ONLY accept GET requests
//    @ResponseBody                                   // Tells SpringBoot that this method will return a plain text response
//    public String hello() {
//        return "Hello, Spring!";
//    }


    // Handles request at path /goodbye
    @GetMapping("goodbye")                                     // Tells SpringBoot that this method will ONLY accept GET requests
    @ResponseBody                                              // Tells SpringBoot that this method will return a plain text response
    public String goodbye() {
        return "GoodBye, Spring!";
    }


    // responds to get and post requests at /hellogoodbye
    @RequestMapping (value = "hellogoodbye", method = {RequestMethod.GET, RequestMethod.POST})
    public String hellogoodbye() {
        return "Hello & Goodbye!";
    }



    /**** @RequestParam Examples ****/

    // Handles request of the form /hello?name=LaunchCode
    @GetMapping ("hello")
    @ResponseBody
    public String helloWithQueryParam(@RequestParam String name) {
        return "Hello, " + name + "!";
    }

    // Handles request of the form /launchcode?coder=LaunchCode
    @GetMapping ("launchcode")
    @ResponseBody
    public String launchcodeWithQueryParam(@RequestParam String coder) {
        return "Hello, " + coder + " is a student at LaunchCode!";
    }



    /**** @PathParam Examples ****/

    // Handles request od the form /hello/LaunchCode
    @GetMapping("hello/{name}")
    @ResponseBody
    public String helloWithPathParam(@PathVariable String name) {
        return "Hello, " + name + "!";
    }



    /**** Forms Examples ****/
    @GetMapping("form")
    @ResponseBody
    public String helloForm() {
        return "<html>" +
                "<body>" +
                "<form action='hello'>" +                       // Submits a request to /hello
                "<input type='text' name='name'>" +
                "<input type='submit' value='Greet me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }


}
