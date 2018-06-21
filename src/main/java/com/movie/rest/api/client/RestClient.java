package com.movie.rest.api.client;
import org.slf4j.*;
public class RestClient {
	private static final Logger logger = LoggerFactory.getLogger(RestClient.class);
	private RestClientConfigurator clientConfigurator = new RestClientConfigurator();
	private static RestClient restClient;
	public static RestClient getInstance(){
		if(null == restClient)
			restClient = new RestClient();
		return restClient;
	}
	public String getEndPointURL(){
		logger.info("URL is ->"+clientConfigurator.getBaseURI()+clientConfigurator.getApiKey());
		return clientConfigurator.getBaseURI()+clientConfigurator.getApiKey();
	}
}
