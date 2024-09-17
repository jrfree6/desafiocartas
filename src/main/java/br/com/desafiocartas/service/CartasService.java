package br.com.desafiocartas.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import br.com.desafiocartas.feign.DeckOfCardsClient;
import br.com.desafiocartas.feign.DeckResponseData;
import br.com.desafiocartas.model.Card;
import br.com.desafiocartas.model.Game;
import br.com.desafiocartas.model.Player;
import br.com.desafiocartas.repository.GameRepository;

@Service
public class CartasService {
	
	Logger log = LoggerFactory.getLogger(CartasService.class);
	
	@Autowired
	private DeckOfCardsClient deckOfCardsClient;

    @Autowired
    private GameRepository gameRepository;
	
	private final Map<String, Integer> cardValues = Map.ofEntries(
		    Map.entry("ACE", 1), Map.entry("2", 2), Map.entry("3", 3), Map.entry("4", 4), Map.entry("5", 5),
		    Map.entry("6", 6), Map.entry("7", 7), Map.entry("8", 8), Map.entry("9", 9),Map.entry("10", 10),
		    Map.entry("JACK", 11), Map.entry("QUEEN", 12), Map.entry("KING", 13) );
	
	/** da a mao das cartas...*/
	public List<Player> dealHands(){
		
		
	    DeckResponseData deck = deckOfCardsClient.createDeck();
		List<Player> players = new ArrayList<>();
	        
		log.info("DeckID:" + deck.getDeck_id());
		for(int i =1; i <= 4; i++) {
			List<Card> hand = deckOfCardsClient.drawCards(deck.getDeck_id()).getCards();
			int score = calculateHandScore(hand);
			Player player = new Player("Jogador " + i, hand, score);
			players.add(player);
			saveGame(deck, player);
		}
       
		
		return players;
	}
	/** salva a mao dos jogadores e o id da rodada */
	private void saveGame(DeckResponseData deck, Player player) {
		try {
			Gson gson = new Gson();
			Game game = new Game(deck.getDeck_id(), gson.toJson(player));
			gameRepository.save(game); // Salvar o jogo completo

		} catch (Exception e) {
			log.error("Falho ao persistir o jogo.");
		}
	}
	
	/** Calcula o score do player **/
	public int calculateHandScore(List<Card> hand) {
		
		for (Card card2 : hand) {
			log.info("Card:" + card2.getValue() +" - "+cardValues.get(card2.getValue()));
		}
		return hand.stream().mapToInt(card -> cardValues.get(card.getValue())).sum();
	}
	
	/** Verifica o vencedor, busca na lista o maior score */
	public List<Player> determineWinner(List<Player> players){
		int maxScore = players.stream().max(Comparator.comparing(Player::getScore)).get().getScore();
		return players.stream().filter(player -> player.getScore() == maxScore).collect(Collectors.toList());
	}

}
