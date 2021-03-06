package edu.umb.cs680.hw13;

import org.junit.jupiter.api.Test;

class DJIAQuoteObservableTest {

	@Test
	void DjiaQuoteTest() {
		PiechartObserver PiechartObserver = new PiechartObserver();
		TableObserver TableObserver = new TableObserver();
		ThreeDObserver THREEDObserver = new ThreeDObserver();

		DJIAQuoteObservable djiaObserver = new DJIAQuoteObservable();
		djiaObserver.addObserver(PiechartObserver);
		djiaObserver.addObserver(TableObserver);
		djiaObserver.addObserver(THREEDObserver);

		djiaObserver.changeQuote(65);
		djiaObserver.changeQuote(70);
	}
}
