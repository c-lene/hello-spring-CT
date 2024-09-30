package org.launchcode.hello_spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@ResponseBody
@RequestMapping("hello")                                        // Every single method within this class should BEGIN route with "/hello" - And anything after is an additional path added
public class HelloController {

    // Handles request at path /hello
//    @GetMapping("hello")                                     // Tells SpringBoot that this method will ONLY accept GET requests
//    @ResponseBody                                            // Tells SpringBoot that this method will return a plain text response
//    public String hello() {
//        return "Hello, Spring!";
//    }


    // Handles request at path /hello/goodbye
    @GetMapping("goodbye")                                     // Tells SpringBoot that this method will ONLY accept GET requests
//    @ResponseBody                                              // Tells SpringBoot that this method will return a plain text response
    public String goodbye() {
        return "GoodBye, Spring!";
    }



    /**** @RequestMapping Example ****/
    // Responds to GET and POST requests at /hello/hellogoodbye
    @RequestMapping (value = "hellogoodbye", method = {RequestMethod.GET, RequestMethod.POST})
    public String hellogoodbye() {
        return "Hello & Goodbye!";
    }

    // Responds to GET and POST requests at /hello
    @RequestMapping (method = {RequestMethod.GET, RequestMethod.POST})
    public String helloWithQueryParam(@RequestParam String name) {
        return "Hello, " + name + "!";
    }




    /**** @RequestParam Examples ****/

    // Handles request of the form /hello?name=LaunchCode
//    @GetMapping ("hello")
//    public String helloWithQueryParam(@RequestParam String name) {
//        return "Hello, " + name + "!";
//    }

    // Handles request of the form /hello/launchcode?coder=LaunchCode
    @GetMapping ("launchcode")
    public String launchcodeWithQueryParam(@RequestParam String coder) {
        return "Hello, " + coder + " is a student at LaunchCode!";
    }



    /**** @PathParam Examples ****/

    // Handles request of the form /hello/LaunchCode
    @GetMapping("{name}")
    public String helloWithPathParam(@PathVariable String name) {
        return "Hello, " + name + "!";
    }




    /**** Forms Examples ****/

    // Route is at /hello/form
    @GetMapping("form")
    public String helloForm() {
        return "<html>" +
                "<body>" +
//                "<form action='hello'>" +                        // Submits a GET request to /hello - Uses Default GET request due to no method specified
                "<form action='hello' method='post'?>" +           // Submits a POST request to /hello
                "<input type='text' name='name'>" +
                "<input type='submit' value='Greet me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }

}
