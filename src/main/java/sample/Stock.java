package sample;

public class Stock {

	private String symbol;
	private double threshold;
	
	public Stock(String symbol, double threshold) {
		this.symbol = symbol;
		this.threshold = threshold;
	}

	public void tradeAt(double price) {
		this.threshold = price;
		
	}

	public Status getStatus() {
		return new Status();
	}

}
