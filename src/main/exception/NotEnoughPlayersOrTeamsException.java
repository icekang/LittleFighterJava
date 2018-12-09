package main.exception;

public class NotEnoughPlayersOrTeamsException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6591836731361241526L;

	public NotEnoughPlayersOrTeamsException(String message) { 
		super(message); 
	}
}
