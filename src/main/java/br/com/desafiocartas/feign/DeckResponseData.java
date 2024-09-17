package br.com.desafiocartas.feign;

public class DeckResponseData {
	private String deck_id;
    private boolean success;
    private String remaining;
    
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
	/**
	 * @return the remaining
	 */
	public final String getRemaining() {
		return remaining;
	}
	/**
	 * @param remaining the remaining to set
	 */
	public final void setRemaining(String remaining) {
		this.remaining = remaining;
	}

}