package sample.jbehave.steps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sample.rest.SimpleRestClient;

@Component
public class ServiceInfoSteps {

	@Autowired
	private SimpleRestClient simpleServiceInfoClient; 
	
	private String serviceEnpoint;
	private String resource;
	private String mediaType;
	
	@Given("a $type web service located at $serviceEnpoint")
	public void givenARESTFulWebServiceLocatedAtURL(String type, String serviceEnpoint){
		System.out.println("DEBUG service type: ["+type+"] serviceEnpoint ["+ serviceEnpoint+"]");
		this.serviceEnpoint = serviceEnpoint;
	}
	
	@When("a $verb request is made to resource $resource for $mediaType")
	public void whenAGETRequestIsMadeToResource(String verb, String resource, String mediaType){
		System.out.println("DEBUG verb ["+ verb + "] and resource ["+resource+"] and mediaType ["+mediaType);
		this.resource = resource;
		this.mediaType = mediaType;
	}
	
	@Then("the expected response is $response")
	public void thenTheExpectedResponseIs(String response){
		System.out.println("DEBUG response ["+ response+"]");
		String actualResponse = simpleServiceInfoClient.callResource(serviceEnpoint, resource, mediaType);
		assertThat(response, equalTo(actualResponse));
	}	
	
}
