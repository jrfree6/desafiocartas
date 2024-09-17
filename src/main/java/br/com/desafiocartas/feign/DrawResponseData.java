package br.com.desafiocartas.feign;

import java.util.List;

import br.com.desafiocartas.model.Card;

public class DrawResponseData {
    private List<Card> cards;
    private String deck_id;
    private boolean success;
    
	/**
	 * @return the cards
	 */
	public final List<Card> getCards() {
		return cards;
	}
	/**
	 * @param cards the cards to set
	 */
	public final void setCards(List<Card> cards) {
		this.cards = cards;
	}
	/**
	 * @return the deck_id
	 */
	public final String getDeck_id() {
		return deck_id;
	}
	/**
	 * @param deck_id the deck_id to set
	 */
	public final void setDeck_id(String deck_id) {
		this.deck_id = deck_id;
	}
	/**
	 * @return the success
	 */
	public final boolean isSuccess() {
		return success;
	}
	/**
	 * @param success the success to set
	 */
	public final void setSuccess(boolean success) {
		this.success = success;
	}
}