package edu.umb.cs680.hw03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrimeGeneratorTest {

    @Test
    public void primeGeneratorTest1to30(){
        PrimeGenerator gen = new PrimeGenerator(1,30);
        gen.generatePrimes();
        Long[] expectedPrimes = {2L,3L,5L,7L,11L,13L,17L,19L,23L,29L};
        assertArrayEquals(expectedPrimes,gen.getPrimes().toArray());
    }

    @Test
    public void primeGeneratorTest50to80(){
        PrimeGenerator gen = new PrimeGenerator(50,80);
        gen.generatePrimes();
        Long[] expectedPrimes = {53L, 59L, 61L, 67L, 71L, 73L, 79L};
        assertArrayEquals(expectedPrimes,gen.getPrimes().toArray());
    }

    @Test
    public void primeGeneratorTest20to1(){
        long from = 20;
        long to = 1;
        try {
            PrimeGenerator gen = new PrimeGenerator(from,to);
            gen.generatePrimes();
            Long[] expectedPrimes = {};
            assertArrayEquals(expectedPrimes,gen.getPrimes().toArray());
        } catch (RuntimeException e) {
            assertEquals("Wrong input values: from=" + from + " to=" + to,e.getMessage());
        }
    }

    @Test
    public void primeGeneratorTestNegativeFrom(){
        long from = -20;
        long to = 20;
        try {
            PrimeGenerator gen = new PrimeGenerator(from,to);
            gen.generatePrimes();
            Long[] expectedPrimes = {};
            assertArrayEquals(expectedPrimes,gen.getPrimes().toArray());
        } catch (RuntimeException e) {
            assertEquals("Wrong input values: from=" + from + " to=" + to,e.getMessage());
        }
    }

}