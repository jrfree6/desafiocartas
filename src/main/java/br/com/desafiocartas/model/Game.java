package br.com.desafiocartas.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "game")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String jsonGame;
    private String deckId;

    public Game() {}

    public Game(String deckId, String json) {
        this.jsonGame = json;
        this.deckId = deckId;
    }

    public Long getId() {
        return id;
    }

	/**
	 * @return the jsonGame
	 */
	public String getJsonGame() {
		return jsonGame;
	}

	/**
	 * @param jsonGame the jsonGame to set
	 */
	public void setJsonGame(String jsonGame) {
		this.jsonGame = jsonGame;
	}

	/**
	 * @return the deckId
	 */
	public String getDeckId() {
		return deckId;
	}

	/**
	 * @param deckId the deckId to set
	 */
	public void setDeckId(String deckId) {
		this.deckId = deckId;
	}


}