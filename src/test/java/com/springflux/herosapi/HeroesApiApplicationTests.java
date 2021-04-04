package com.springflux.herosapi;

import com.springflux.herosapi.repository.HeroesRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.List;

import static com.springflux.herosapi.constains.HeroesConstant.HEROES_ENDPOINT_LOCAL;


//@RunWith(SpringRunner.class)
@DirtiesContext
@AutoConfigureWebTestClient
@SpringBootTest
public class HeroesApiApplicationTests {
	@Autowired
	WebTestClient webTestClient;

	@Autowired
	HeroesRepository heroesRepository;

	@Test
	public void getOneHeroById(){

		webTestClient.get().uri(HEROES_ENDPOINT_LOCAL.concat("/{id}"),"4")
				.exchange()
				.expectStatus().isOk()
				.expectBody();


	}

	@Test
	public void getOneHeroNotFound(){

		webTestClient.get().uri(HEROES_ENDPOINT_LOCAL.concat("/{id}"),"10")
				.exchange()
				.expectStatus().isNotFound();
	}

	@Test
	public void deleteHero(){

		webTestClient.delete().uri(HEROES_ENDPOINT_LOCAL.concat("/{id}"),"3")
				.accept(MediaType.APPLICATION_JSON)
				.exchange()
				.expectStatus().isNoContent()
				.expectBody(Void.class);
	}
}
