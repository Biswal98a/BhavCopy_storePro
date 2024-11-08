package com.BhavCopy_storedPro.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.BhavCopy_storedPro.entity.BhavCopy;
import com.BhavCopy_storedPro.repository.BhavCopyRepository;

@Service
public class BhavCopyService {
	
	private  BhavCopyRepository bhavCopyRepository;
	
	public BhavCopyService(BhavCopyRepository bhavCopyRepository) {
		this.bhavCopyRepository=bhavCopyRepository;
	}
	
	public List<BhavCopy> getSymbolInfo(String symbol) {
        return bhavCopyRepository.findSymbolInfo(symbol);
    }
	 
	public int getCountSymbolsBySeries(String seriesInput) {
	        return bhavCopyRepository.countSymbolsBySeries(seriesInput);
	    }
	 
	public List<String> getSymbolsByGain(double n) {
	        return bhavCopyRepository.listSymbolsByGain(n);
	    }
	 
	public List<String> getSymbolsByRange(double n) {
	        return bhavCopyRepository.listSymbolsByRange(n);
	    }
	
	public double getStdDevForSeries(String seriesInput) {
	        return bhavCopyRepository.getStdDevForSeries(seriesInput);
	    }
	 
	public List<String> getTopGainers(int n) {
	        List<Object[]> results = bhavCopyRepository.findTopGainers(n);
	        
	        // Assuming the result is a list of symbols, cast the first column of each row to String
	        return results.stream()
	                .map(row -> (String) row[0])  // Cast the first column (symbol) to String
	                .collect(Collectors.toList());
	    }
	 
	public List<String> getTopLaggards(int n) {
	        return bhavCopyRepository.findTopLaggards(n);
	    }
	 
	public List<String> getTopTradedSymbols(int n) {
	        return bhavCopyRepository.findTopTradedSymbols(n);
	    }
	 
	public List<String> getBotTradedSymbols(int n) {
	        return bhavCopyRepository.findBotTradedSymbols(n);
	    }
	 
	public List<Object[]> getHighLowTradedSymbols(String seriesInput) {
	        return bhavCopyRepository.getHighLowTradedSymbols(seriesInput);
	    }

}
