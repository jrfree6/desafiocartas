package br.com.desafiocartas;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.desafiocartas.model.Card;
import br.com.desafiocartas.model.Player;
import br.com.desafiocartas.service.CartasService;

@SpringBootTest
public class CartasServiceTests {

	@Autowired
	private CartasService cartasService;
		
	@Test
    public void testDetermineWinner() {
        // Criando jogadores fictícios com suas mãos e pontuações
        Player player1 = new Player("Jogador 1", Arrays.asList(
            new Card("ACE", "HEARTS"),
            new Card("2", "DIAMONDS"),
            new Card("3", "CLUBS"),
            new Card("4", "SPADES"),
            new Card("5", "HEARTS")
        ), 15);

        Player player2 = new Player("Jogador 2", Arrays.asList(
            new Card("KING", "HEARTS"),
            new Card("Q", "DIAMONDS"),
            new Card("JACK", "CLUBS"),
            new Card("10", "SPADES"),
            new Card("9", "HEARTS")
        ), 55);

        Player player3 = new Player("Jogador 3", Arrays.asList(
            new Card("8", "HEARTS"),
            new Card("9", "DIAMONDS"),
            new Card("2", "CLUBS"),
            new Card("ACE", "SPADES"),
            new Card("JACK", "HEARTS")
        ), 31);

        Player player4 = new Player("Jogador 4", Arrays.asList(
            new Card("2", "HEARTS"),
            new Card("2", "DIAMONDS"),
            new Card("5", "CLUBS"),
            new Card("7", "SPADES"),
            new Card("2", "HEARTS")
        ), 18);

        // Lista de jogadores
        List<Player> players = Arrays.asList(player1, player2, player3, player4);

        // Verificando se o vencedor é o Jogador 2
        List<Player> winners = cartasService.determineWinner(players);
        assertEquals(1, winners.size(), "Deve haver apenas um vencedor");
        assertEquals("Jogador 2", winners.get(0).getName(), "O vencedor deve ser o Jogador 2");
    }

    @Test
    public void testDetermineWinnerWithTie() {
        // Jogador 1 e Jogador 2 têm a mesma pontuação
        Player player1 = new Player("Jogador 1", Arrays.asList(
            new Card("ACE", "HEARTS"),
            new Card("KING", "DIAMONDS"),
            new Card("JACK", "CLUBS"),
            new Card("QUEEN", "SPADES"),
            new Card("5", "HEARTS")
        ), 40);

        Player player2 = new Player("Jogador 2", Arrays.asList(
            new Card("ACE", "SPADES"),
            new Card("KING", "HEARTS"),
            new Card("JACK", "DIAMONDS"),
            new Card("QUEEN", "CLUBS"),
            new Card("5", "SPADES")
        ), 40);

        Player player3 = new Player("Jogador 3", Arrays.asList(
            new Card("10", "HEARTS"),
            new Card("9", "DIAMONDS"),
            new Card("8", "CLUBS"),
            new Card("7", "SPADES"),
            new Card("6", "HEARTS")
        ), 40);

        Player player4 = new Player("Jogador 4", Arrays.asList(
            new Card("2", "HEARTS"),
            new Card("2", "DIAMONDS"),
            new Card("5", "CLUBS"),
            new Card("7", "SPADES"),
            new Card("2", "HEARTS")
        ), 18);

        // Lista de jogadores
        List<Player> players = Arrays.asList(player1, player2, player3, player4);

        // Verificando se há três vencedores com empate
        List<Player> winners = cartasService.determineWinner(players);
        assertEquals(3, winners.size(), "Deve haver três vencedores");
        assertEquals("Jogador 1", winners.get(0).getName());
        assertEquals("Jogador 2", winners.get(1).getName());
        assertEquals("Jogador 3", winners.get(2).getName());
    }
    
}
