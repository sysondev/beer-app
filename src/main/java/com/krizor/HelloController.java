package com.krizor;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(value = "/beer-app")
public class HelloController implements ErrorController {

    @RequestMapping("/bira/{antal}")
    public Map<String, Integer> index(@PathVariable Integer antal) {
        return Collections.singletonMap("bira", antal);
    }

    private ArrayList<String> biror = new ArrayList<>(Arrays.asList("Carlsberg", "Brooklyn", "Mikeller"));

    @RequestMapping("/biror")
    public Map<String, List<String>> index() {
        return Collections.singletonMap("biror", biror);
    }

    @RequestMapping(value = "/crab", method = RequestMethod.POST)
    public String crab(@RequestParam String text) {
        return text;
    }

    @RequestMapping(value = "/laggtillbira/{brand}", method = RequestMethod.POST)
    public Map<String, List<String>> index(@PathVariable String brand) {
        biror.add(brand);

        return Collections.singletonMap("biror", biror);
    }

    private static final String PATH = "/error";

    @RequestMapping(value = PATH)
    public String error() {
        return "Du får exakt NOLL bira för du gjorde ALLT fel.";
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }
}