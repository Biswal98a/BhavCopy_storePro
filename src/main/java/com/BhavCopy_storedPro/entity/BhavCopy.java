package com.BhavCopy_storedPro.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="bhav_copy") 
public class BhavCopy {
	 @Id
	    private String symbol;
	    
	    private String series;
	    private String date1;
	    
	    @Column(name = "prev_close")
	    private double prevClose;
	    
	    @Column(name = "open_price")
	    private double openPrice;
	    
	    @Column(name = "high_price")
	    private double highPrice;
	    
	    @Column(name = "low_price")
	    private double lowPrice;
	    
	    @Column(name = "last_price")
	    private double lastPrice;
	    
	    @Column(name = "close_price")
	    private double closePrice;
	    
	    @Column(name = "avg_price")
	    private double avgPrice;
	    
	    @Column(name = "ttl_trd_qnty")
	    private double ttlTrdQnty;
	    
	    @Column(name = "turnover_lacs")
	    private double turnoverLacs;
	    
	    @Column(name = "no_of_trades")
	    private double noOfTrades;
	    
	    @Column(name = "deliv_qty")
	    private double delivQty;
	    
	    @Column(name = "deliv_per")
	    private double delivPer;

		public String getSymbol() {
			return symbol;
		}

		public void setSymbol(String symbol) {
			this.symbol = symbol;
		}

		public String getSeries() {
			return series;
		}

		public void setSeries(String series) {
			this.series = series;
		}

		public String getDate1() {
			return date1;
		}

		public void setDate1(String date1) {
			this.date1 = date1;
		}

		public double getPrevClose() {
			return prevClose;
		}

		public void setPrevClose(double prevClose) {
			this.prevClose = prevClose;
		}

		public double getOpenPrice() {
			return openPrice;
		}

		public void setOpenPrice(double openPrice) {
			this.openPrice = openPrice;
		}

		public double getHighPrice() {
			return highPrice;
		}

		public void setHighPrice(double highPrice) {
			this.highPrice = highPrice;
		}

		public double getLowPrice() {
			return lowPrice;
		}

		public void setLowPrice(double lowPrice) {
			this.lowPrice = lowPrice;
		}

		public double getLastPrice() {
			return lastPrice;
		}

		public void setLastPrice(double lastPrice) {
			this.lastPrice = lastPrice;
		}

		public double getClosePrice() {
			return closePrice;
		}

		public void setClosePrice(double closePrice) {
			this.closePrice = closePrice;
		}

		public double getAvgPrice() {
			return avgPrice;
		}

		public void setAvgPrice(double avgPrice) {
			this.avgPrice = avgPrice;
		}

		public double getTtlTrdQnty() {
			return ttlTrdQnty;
		}

		public void setTtlTrdQnty(double ttlTrdQnty) {
			this.ttlTrdQnty = ttlTrdQnty;
		}

		public double getTurnoverLacs() {
			return turnoverLacs;
		}

		public void setTurnoverLacs(double turnoverLacs) {
			this.turnoverLacs = turnoverLacs;
		}

		public double getNoOfTrades() {
			return noOfTrades;
		}

		public void setNoOfTrades(double noOfTrades) {
			this.noOfTrades = noOfTrades;
		}

		public double getDelivQty() {
			return delivQty;
		}

		public void setDelivQty(double delivQty) {
			this.delivQty = delivQty;
		}

		public double getDelivPer() {
			return delivPer;
		}

		public void setDelivPer(double delivPer) {
			this.delivPer = delivPer;
		}
	    
	
	    

}
