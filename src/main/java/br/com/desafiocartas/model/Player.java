package br.com.desafiocartas.model;

import java.util.List;

public class Player {
	
	private String name;
	private List<Card> hand; // Armazena a mão do jogador
	private int score;
	
	// Construtores, getters e setters
	public Player() {}
	
	/**
	 * Construtor
	 * @param name
	 * @param hand
	 * @param score
	 */
	public Player(String name, List<Card> hand, int score) {
		super();
		this.name = name;
		this.hand = hand;
		this.score = score;
	}
	
	/**
	 * @return the name
	 */
	public final String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public final void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the hand
	 */
	public final List<Card> getHand() {
		return hand;
	}
	/**
	 * @param hand the hand to set
	 */
	public final void setHand(List<Card> hand) {
		this.hand = hand;
	}
	/**
	 * @return the score
	 */
	public final int getScore() {
		return score;
	}
	/**
	 * @param score the score to set
	 */
	public final void setScore(int score) {
		this.score = score;
	}
	

}
