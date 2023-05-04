package com.Geekster.RandomJokes.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class JokesController {
    ArrayList<String> jokesList= new ArrayList<>();
    @PostMapping(value = "/jokes")
    public String postJokes(@RequestBody String jokesValue){
//        jokesList.add("Shahrukh khan srk Softwere Developer");
        jokesList.add(jokesValue);
        return "Saved Jokes";
    }
    @GetMapping(value = "/jokes")
    public String getJokes(){

//        jokesList.add("Hello hey mr shahrukh how are you");
//        jokesList.add("what are you doing mr srk");
//        jokesList.add("you are doing work with us are you happy");
        int randomValue = 0+(int)(Math.random()*((jokesList.size()-1-0)+1));
        return jokesList.get(randomValue);
    }
}
