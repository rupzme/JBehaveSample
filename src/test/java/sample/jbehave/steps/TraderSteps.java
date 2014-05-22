package sample.jbehave.steps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sample.Stock;

@Component
public class TraderSteps {
	  
	@Autowired
    private Stock stock;
 
    @Given("a stock of symbol $symbol and a threshold of $threshold")
    public void aStock(String symbol, double threshold) {
    	stock.setThreshold(threshold);
    	stock.setSymbol(symbol);
    }
 
    @When("the stock is traded at $price")
    public void theStockIsTradedAt(double price) {
        stock.tradeAt(price);
    }
 
    @Then("the alert status should be $status")
    public void theAlertStatusShouldBe(String status) {
    	assertThat(stock.getStatus().name(), equalTo(status));
    }
 
}
