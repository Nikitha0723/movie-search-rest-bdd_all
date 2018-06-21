package com.movie.rest.api.client;


public class RestClientConfigurator {
	private String baseURI;
	private String apiKey;
	
	public RestClientConfigurator(){
		baseURI = Constants.API_URL;
		apiKey = Constants.API_KEY;
	}
	
	public String getBaseURI(){
		return baseURI;
	}
	
	public void setBaseURI(String baseURI){
		this.baseURI = baseURI;
	}
	public String getApiKey(){
		return apiKey;
	}
	
	public void setApiKey(String apiKey){
		this.apiKey = apiKey;
	}

}
