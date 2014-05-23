package sample.rest;

import org.apache.cxf.jaxrs.client.WebClient;
import org.springframework.stereotype.Component;

@Component
public class SimpleRestClient {

	public String callResource(String baseUrl, String resource, String mediaType) {

		WebClient client = WebClient.create(baseUrl);

		String response = client.path(resource + "/").accept(mediaType)
				.get(String.class);

		System.out.println("response: "+response);
		
		return response;
	}

}
