package com.BhavCopy_storedPro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.BhavCopy_storedPro.entity.BhavCopy;

public interface BhavCopyRepository extends JpaRepository<BhavCopy, String> {
	
	@Query(value = "SELECT * FROM get_symbol_info(:symbol_input)", nativeQuery = true)
    List<BhavCopy> findSymbolInfo(@Param("symbol_input") String symbolInput);
	
	@Query(value = "SELECT count_symbols_by_series(:series_input)", nativeQuery = true)
    int countSymbolsBySeries(@Param("series_input") String seriesInput);
	
	@Query(value = "SELECT * FROM list_symbols_by_gain(:n)", nativeQuery = true)
    List<String> listSymbolsByGain(@Param("n") double n);
	
	 @Query(value = "SELECT * FROM list_symbols_by_range(:n)", nativeQuery = true)
	    List<String> listSymbolsByRange(@Param("n") double n);
	 
	 @Query(value = "SELECT stddev_for_series(:series_input)", nativeQuery = true)
	    double getStdDevForSeries(@Param("series_input") String seriesInput);
	 
	 @Query(value = "SELECT * FROM top_gainers(:n)", nativeQuery = true)
	    List<Object[]> findTopGainers(@Param("n") int n);
	    
	 @Query(value = "SELECT * FROM top_laggards(:n)", nativeQuery = true)
	    List<String> findTopLaggards(@Param("n") int n);
	 
	 @Query(value = "SELECT * FROM top_traded(:n)", nativeQuery = true)
	    List<String> findTopTradedSymbols(@Param("n") int n);
	 
	 @Query(value = "SELECT * FROM bot_traded(:n)", nativeQuery = true)
	    List<String> findBotTradedSymbols(@Param("n") int n);
	 
	 @Query(value = "SELECT * FROM highlow_traded(:seriesInput)", nativeQuery = true)
	    List<Object[]> getHighLowTradedSymbols(String seriesInput);
	    
	
	

}
