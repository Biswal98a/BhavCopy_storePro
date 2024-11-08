package com.BhavCopy_storedPro;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import com.BhavCopy_storedPro.entity.BhavCopy;
import com.BhavCopy_storedPro.repository.BhavCopyRepository;

@DataJpaTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) 
//prevents Spring Boot from replacing your database with an in-memory database during testing.
public class BhavCopyRepositoryTest {
	@Autowired
    private BhavCopyRepository bhavCopyRepository;
	
	@Test
    public void testFindSymbolInfo() {
        // Expected output based on test data in the database
        String symbolInput = "1018GS2026";
        List<BhavCopy> result = bhavCopyRepository.findSymbolInfo(symbolInput);
        // Assertions
        assertThat(result).isNotEmpty();
        assertThat(result.get(0).getSymbol()).isEqualTo("1018GS2026");
        assertThat(result.get(0).getSeries()).isEqualTo("GS");
        assertThat(result.get(0).getOpenPrice()).isEqualTo(109.99);
    }
	 @Test
	    public void testCountSymbolsBySeries() {
	        // Expected output based on test data in the database
	        String seriesInput = "EQ";
	        int expectedCount = 1916;  // Assuming there are 2 records with series "EQ" in test data

	        int actualCount = bhavCopyRepository.countSymbolsBySeries(seriesInput);

	        assertThat(actualCount).isEqualTo(expectedCount);
	    }
	 @Test
	    public void testListSymbolsByGain() {
	        double gainThreshold = 5.0;
	        List<String> result = bhavCopyRepository.listSymbolsByGain(gainThreshold);
	        assertThat(result).isNotEmpty();
	        assertThat(result).contains("MITCON");  
	    }
	 @Test
	    public void testListSymbolsByRange() {
	        // Arrange: set up the test input value
	        double rangeInput = 5.0; // Adjust this based on your test data
	        
	        // Act: call the method being tested
	        List<String> result = bhavCopyRepository.listSymbolsByRange(rangeInput);

	        // Assert: verify the results
	        assertThat(result).isNotEmpty(); // Check that result is not empty
	        assertThat(result).contains("360ONE"); 
	    }
	 @Test
	    public void testGetStdDevForSeries() {
	        String seriesInput = "EQ";
	        double expectedStdDev = 3938.44973149371;  // Replace with actual expected standard deviation value

	        double actualStdDev = bhavCopyRepository.getStdDevForSeries(seriesInput);

	        // Assertion with delta for floating-point comparison
	        assertThat(actualStdDev).isCloseTo(expectedStdDev, within(0.1));
	    }
	 @Test
	    public void testFindTopGainers() {
	        int topN = 5;
	        List<Object[]> result = bhavCopyRepository.findTopGainers(topN);

	        // Assertions
	        assertThat(result).isNotEmpty();
	        assertThat(result.size()).isLessThanOrEqualTo(topN);
	        assertThat(result.get(0)[0]).isEqualTo("VILINBIO");  // Assuming "VILINBIO" is a top gainer
	      
	    }
	 @Test
	    public void testFindTopLaggards() {
	        int topN = 5;
	        List<String> result = bhavCopyRepository.findTopLaggards(topN);
	        assertThat(result).isNotEmpty();
	        assertThat(result.size()).isLessThanOrEqualTo(topN);
	        assertThat(result).contains("NSIL");  // Assuming "TCS" is a laggard in the test data
	    }
	 @Test
	    public void testFindTopTradedSymbols() {
	        int topN = 5;
	        List<String> result = bhavCopyRepository.findTopTradedSymbols(topN);
	        assertThat(result).isNotEmpty();
	        assertThat(result.size()).isLessThanOrEqualTo(topN);
	        assertThat(result).contains("NSIL");  // Assuming "NSIL" is among top traded symbols
	    }
	 @Test
	    public void testFindBotTradedSymbols() {
	        int topN = 5;
	        List<String> result = bhavCopyRepository.findBotTradedSymbols(topN);
	        assertThat(result).isNotEmpty();
	        assertThat(result.size()).isLessThanOrEqualTo(topN);
	        assertThat(result).contains("VHL");  // Assuming "VHL" is a bot traded symbol in the test data
	    }
	 @Test
	    public void testGetHighLowTradedSymbols() {
	        String seriesInput = "EQ";
	        List<Object[]> result = bhavCopyRepository.getHighLowTradedSymbols(seriesInput);
	        assertThat(result).isNotEmpty();
	        assertThat(result.get(0)[0]).isEqualTo("IDEA");  // Assuming "IDEA" is in high-low traded
	    }

}
