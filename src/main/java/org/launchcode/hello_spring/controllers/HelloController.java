package org.launchcode.hello_spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class HelloController {


    // Responds to GET and POST requests at http://localhost:8080/hello?name=LaunchCode
    // Handles request of the form
    @RequestMapping (method = {RequestMethod.GET, RequestMethod.POST}, value="hello")
    @ResponseBody
    public String helloWithQueryParam(@RequestParam String name) {
        return "Hello, " + name + "!";
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

    @GetMapping("form")
    @ResponseBody
    public String helloForm() {
        String html = "<html>" +
                "<body>" +
                "<form action = '/hello' method = 'post'>" +           // Submits a POST request to /hello
                "<input type = 'text' name = 'name' />" +
                "<input type = 'submit' value = 'Greet me!' />" +
                "</form>" +
                "</body>" +
                "</html>";
        return html;
    }

}
