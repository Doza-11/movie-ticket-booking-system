package controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import requests.MovieRequest;

@RestController
@RequestMapping("/movie")
public class MovieController {
    @PostMapping("/addNew")
    public ResponseEntity<String> addNewMovie(@RequestBody MovieRequest movieRequest) {
gsgsgs
    }
}
