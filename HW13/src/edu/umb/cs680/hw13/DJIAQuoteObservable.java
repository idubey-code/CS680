package edu.umb.cs680.hw13;

import java.util.Observable;


public class DJIAQuoteObservable extends Observable{
	
	float quote;
	void changeQuote(float quote) {
		this.quote = quote;
		setChanged();
		notifyObservers(new DJIAEvent(quote));
	}
	
	public static void main(String[] args) {
		System.out.println("DJIAQuoteObservable class has run successfully");
	}
}
