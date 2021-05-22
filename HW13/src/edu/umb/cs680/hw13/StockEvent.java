package edu.umb.cs680.hw13;

public class StockEvent {
	
	public String ticker;
	public float quote;

	public StockEvent(String ticker, float quote) {
		this.ticker = ticker;
		this.quote = quote;
	}
	public float getQuote()
	{
		return quote;
	}

	public String getTicker()
	{
		return ticker;
	}

	public static void main(String[] args) {
		System.out.println("StockEvent is run successfully");
	}
}
