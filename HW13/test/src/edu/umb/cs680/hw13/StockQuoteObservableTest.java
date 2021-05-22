package edu.umb.cs680.hw13;

import org.junit.jupiter.api.Test;

class StockQuoteObservableTest {

	@Test
	void DjiaQuoteTest() {
		PiechartObserver PiechartObserver = new PiechartObserver();
		TableObserver TableObserver = new TableObserver();
		ThreeDObserver server = new ThreeDObserver();

		StockQuoteObservable djiaObserver = new StockQuoteObservable();
		djiaObserver.addObserver(PiechartObserver);
		djiaObserver.addObserver(TableObserver);
		djiaObserver.addObserver(server);

		djiaObserver.changeQuote("JOHN",65);
		djiaObserver.changeQuote("ALEX",70);
	}
}

