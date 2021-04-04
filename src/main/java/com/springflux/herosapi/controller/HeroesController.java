package com.springflux.herosapi.controller;

import com.springflux.herosapi.document.Heroes;
import com.springflux.herosapi.repository.HeroesRepository;
import com.springflux.herosapi.service.HeroesService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static com.springflux.herosapi.constains.HeroesConstant.HEROES_ENDPOINT_LOCAL;

@Slf4j
@RestController
@RequiredArgsConstructor
public class HeroesController {
    private final HeroesService heroesService;
    private final HeroesRepository heroesRepository;

    @GetMapping(HEROES_ENDPOINT_LOCAL)
    @ResponseStatus(HttpStatus.OK)
    public Flux<Heroes> getAllItems() {
        log.info("requesting the list off all heroes");
        return heroesService.findAll();
    }

    @GetMapping(HEROES_ENDPOINT_LOCAL + "/{id}")
    public Mono<ResponseEntity<Heroes>> findByIdHero(@PathVariable String id) {
        log.info("Requesting the hero with id {}", id);
        return heroesService.findByIdHero(id)
                .map((item) -> new ResponseEntity<>(item, HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(HEROES_ENDPOINT_LOCAL)
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Heroes> createHero(@RequestBody Heroes heroes) {
        log.info("A new Hero was Created");
        return heroesService.save(heroes);
    }

    @DeleteMapping(HEROES_ENDPOINT_LOCAL + "/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public Mono<HttpStatus> deleteByIDHero(@PathVariable String id) {
        heroesService.deletebyIDHero(id);
        log.info("Deleting the hero with id {}", id);
        return Mono.just(HttpStatus.NO_CONTENT);
    }
}
