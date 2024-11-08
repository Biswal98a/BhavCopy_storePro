package com.BhavCopy_storedPro.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.BhavCopy_storedPro.entity.BhavCopy;
import com.BhavCopy_storedPro.service.BhavCopyService;

@RestController
@RequestMapping("/api/v1/bhavcopy")
public class BhavCopyController {
	
	private BhavCopyService bhavCopyService;
	
	public BhavCopyController (BhavCopyService bhavCopyService ) {
		this.bhavCopyService=bhavCopyService;
	}
	
	@GetMapping("/symbol-info")
    public List<BhavCopy> getSymbolInfo(@RequestParam("symbol") String symbol) {
        return bhavCopyService.getSymbolInfo(symbol);
    }
	 
	@GetMapping("/countSymbolsBySeries")
	    public int countSymbolsBySeries(@RequestParam String series) {
	        return bhavCopyService.getCountSymbolsBySeries(series);
	    }
	
	@GetMapping("/symbols-by-gain")
	    public List<String> getSymbolsByGain(@RequestParam double n) {
	        return bhavCopyService.getSymbolsByGain(n);
	    }
	
	@GetMapping("/symbols-by-range")
	    public ResponseEntity<List<String>> getSymbolsByRange(@RequestParam double n) {
	        List<String> symbols = bhavCopyService.getSymbolsByRange(n);
	        return ResponseEntity.ok(symbols);
	    }
	 
	@GetMapping("/stddev-for-series")
	    public ResponseEntity<Double> getStdDevForSeries(@RequestParam String seriesInput) {
	        double stddev = bhavCopyService.getStdDevForSeries(seriesInput);
	        return ResponseEntity.ok(stddev);
	    }
	 
	@GetMapping("/top-gainers")
	    public List<String> getTopGainers(@RequestParam int n) {
	        return bhavCopyService.getTopGainers(n);
	    }
	 
	@GetMapping("/top-laggards")
	    public List<String> getTopLaggards(@RequestParam int n) {
	        return bhavCopyService.getTopLaggards(n);
	    }
	 
	@GetMapping("/top-traded")
	    public List<String> getTopTradedSymbols(@RequestParam int n) {
	        return bhavCopyService.getTopTradedSymbols(n);
	    }
	
	@GetMapping("/bot-traded")
	    public List<String> getBotTradedSymbols(@RequestParam int n) {
	        return bhavCopyService.getBotTradedSymbols(n);
	    }
	 
	@GetMapping("/highlowtraded/{seriesInput}")
	    public List<Object[]> getHighLowTradedSymbols(@PathVariable String seriesInput) {
	        return bhavCopyService.getHighLowTradedSymbols(seriesInput);
	    }

}
