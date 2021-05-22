package edu.umb.cs680.hw13;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

public class StockQuoteObservable extends Observable{
	
	Map<String, Float> map = new HashMap<String, Float>();
	
	void changeQuote(String ticker,float quote) {
		map.put(ticker, quote);
		setChanged();
		notifyObservers(new StockEvent(ticker,quote));
	}
	
	public static void main(String[] args) {
		System.out.println("StockQuoteObservable is run successfully");
	}
}
