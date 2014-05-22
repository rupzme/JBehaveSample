package sample;

import org.springframework.stereotype.Service;

@Service
public class Stock {

	private String symbol;
	private double threshold;
	private double price;
	
//	public Stock(String symbol, double threshold) {
//		this.setSymbol(symbol);
//		this.setThreshold(threshold);
//	}

	public void tradeAt(double price) {
		this.price = price;
		
	}

	public Status getStatus() {
		if (price >=threshold) return new Status("ON");
		return new Status("OFF");
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public double getThreshold() {
		return threshold;
	}

	public void setThreshold(double threshold) {
		this.threshold = threshold;
	}

}
