package pl.polsl.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Katarzyna on 30.11.2016.
 */
@RestController
@RequestMapping(value = "/book")
public class BookController {

    @RequestMapping("/")
    public String home() {
        return "index";
    }
}
