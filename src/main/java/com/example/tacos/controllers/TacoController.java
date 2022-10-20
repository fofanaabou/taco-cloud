package com.example.tacos.controllers;

import com.example.tacos.domain.Taco;
import com.example.tacos.domain.TacoOrder;
import com.example.tacos.repository.TacoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/api/tacos", produces = {"application/json", "text/xml"})
@CrossOrigin(origins = "http://tacocloud:8080")
@RequiredArgsConstructor
public class TacoController {

    private final TacoRepository tacoRepository;

    @GetMapping
    public Iterable<Taco> recentTacos(@RequestParam String recent) {
        PageRequest page = PageRequest.of(
                0,12, Sort.by("createdAt").descending());
                return tacoRepository.findAll(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Taco> tacoBydId(@PathVariable("id") Long id) {

        Optional<Taco> tacoOptional = tacoRepository.findById(id);
        return tacoOptional.map(taco -> new ResponseEntity<>(taco, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Taco postTaco(@RequestBody Taco taco) {
        return tacoRepository.save(taco);
    }

}
