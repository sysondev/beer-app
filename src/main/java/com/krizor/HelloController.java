package com.krizor;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping(value = "/beer-app")
public class HelloController implements ErrorController{

    @RequestMapping("/bira/{antal}")
    public Map<String, Integer> index(@PathVariable Integer antal) {
        return Collections.singletonMap("bira", antal);
    }

    private ArrayList<String> biror = new ArrayList<>(Arrays.asList("Carlsberg", "Brooklyn", "Mikeller"));

    @RequestMapping("/biror")
    public Map<String, List<String>> index() {
        return Collections.singletonMap("biror", biror);
    }

    @RequestMapping("/crab")
    public String crab() {
        return ":glitch_crab::glitch_crab::glitch_crab::glitch_crab::glitch_crab::glitch_crab::glitch_crab:" +
                ":glitch_crab::glitch_crab::glitch_crab::glitch_crab::glitch_crab::glitch_crab::glitch_crab:" +
                ":glitch_crab::glitch_crab::glitch_crab::glitch_crab::glitch_crab::glitch_crab::glitch_crab:" +
                ":glitch_crab::glitch_crab::glitch_crab::glitch_crab::glitch_crab::glitch_crab::glitch_crab:" +
                ":glitch_crab::glitch_crab::glitch_crab::glitch_crab::glitch_crab::glitch_crab::glitch_crab:";
    }

    @RequestMapping(value="/laggtillbira/{brand}", method= RequestMethod.POST)
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