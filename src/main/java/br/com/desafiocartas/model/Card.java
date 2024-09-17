package br.com.desafiocartas.model;

public class Card {
	
	private String value;
	private String suit;
	
	/**
	 * Construtor
	 * @param value
	 * @param suit
	 */
	public Card(String value, String suit) {
		this.value = value;
		this.suit = suit;
	}
	
	/**
	 * @return the value
	 */
	public final String getValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public final void setValue(String value) {
		this.value = value;
	}
	/**
	 * @return the suit
	 */
	public final String getSuit() {
		return suit;
	}
	/**
	 * @param suit the suit to set
	 */
	public final void setSuit(String suit) {
		this.suit = suit;
	}
	

}
