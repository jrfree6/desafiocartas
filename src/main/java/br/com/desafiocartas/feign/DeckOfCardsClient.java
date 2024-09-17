package br.com.desafiocartas.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "desckOfCardsClient", url = "https://deckofcardsapi.com/api/deck")
public interface DeckOfCardsClient {

	@GetMapping("/new/shuffle/?deck_count=1")
	DeckResponseData createDeck();

	@GetMapping("/{deckId}/draw/?count=5")
	DrawResponseData drawCards(@PathVariable("deckId") String deckId);

}
