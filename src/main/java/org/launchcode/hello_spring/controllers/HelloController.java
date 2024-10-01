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

    // Responds to GET and POST requests at /hello/hello
    @RequestMapping (value = "hello", method = {RequestMethod.GET, RequestMethod.POST})
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

    /* Edited to complete Exercise */
    // Route is at /hello/form
    @GetMapping("form")
    public String helloForm() {
        return "<html>" +
                "<body>" +
//                "<form action='hello'>" +                             // Submits a GET request to /hello - Uses Default GET request due to no method specified
//                "<form action='hello' method='post'?>" +              // Submits a POST request to /hello
                "<form action='helloPost' method='post'?>" +            // Edited the existing form to be identified at "helloPost"
                "<input type='text' name='name'>" +
                "<select name='language' id='language-select'>" +       // Added Drop down Select menu to select greetings in various language
                "<option value='english'>English</option>" +
                "<option value='french'>French</option>" +
                "<option value='viet'>Viet</option>" +
                "<option value='italian'>Italian</option>" +
                "<option value='mandarin'>Mandarin</option>" +
                "</select>" +
                "<input type='submit' value='Greet me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }



    // Responds to POST requests submitted from /hello/form - identifies the form by "helloPost"
    @RequestMapping(value="helloPost", method = RequestMethod.POST)
    public String helloPost(@RequestParam String name, @RequestParam String language) {
        if (name == null) {
            name = "World";
        }

        // Returns the String from createMessage()
        return createMessage(name, language);
    }




    // Prints out Greeting based on selected language from forms "helloPost"
    public static String createMessage(String name, String language) {
        String greeting = "";

        if (language.equals("english")) {
            greeting = "Hello";

        } else if (language.equals("french")) {
            greeting = "Bonjour";

        } else if (language.equals("viet")) {
            greeting = "Xin chao";

        } else if (language.equals("italian")) {
            greeting = "Ciao";

        } else if (language.equals("mandarin")) {
            greeting = "Ni hao";
        }
        return greeting + " " + name + "!";
    }

}
