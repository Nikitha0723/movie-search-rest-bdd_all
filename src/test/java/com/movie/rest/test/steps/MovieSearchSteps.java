package com.movie.rest.test.steps;


import static net.serenitybdd.rest.SerenityRest.rest;
import static net.serenitybdd.rest.SerenityRest.then;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.Matchers.everyItem;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.movie.rest.api.client.RestClient;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.core.Serenity;

public class MovieSearchSteps {
	private static final Logger logger = LoggerFactory.getLogger(MovieSearchSteps.class);
	private RestClient rtClient;
	private static final String REQ_KEY_CD="req";
	private static final String RES_KEY_CD="res";
	private static final String endPOintUrl="endPOintUrl";
	String jsonResponse="";

	public MovieSearchSteps(){
		super();
		rtClient=RestClient.getInstance();
	}
	
	private void saveSessionResponse(Response response){
		Serenity.getCurrentSession().put(RES_KEY_CD, response);
	}
	
	private Response getSaveSessionResponse(){
		return (Response)Serenity.getCurrentSession().get(RES_KEY_CD);
	}
	
	public void setDetails(){
		saveEndPointUrl(rtClient.getEndPointURL());
	} 	
	private void saveEndPointUrl(String endPointUrl) {
		Serenity.getCurrentSession().put(endPOintUrl, endPointUrl);
	}
	private String getSavedEndPointUrl(){
		logger.info("new url is: "+(String) Serenity.getCurrentSession().get(endPOintUrl));
		return (String) Serenity.getCurrentSession().get(endPOintUrl);
	}
	
	public void whenRequestExecuted(){
		saveSessionResponse(rest().given().log().all().auth().preemptive().basic("","").get(getSavedEndPointUrl()));
	}
	public void verifyResponse(String hs){
		getSaveSessionResponse().then().statusCode(Integer.valueOf(hs));
		getSaveSessionResponse().then().log().all();
	}
	private String getErrorMsg(){
		return getSaveSessionResponse().then().extract().path("status_message").toString();
	}

	public void verifyErrorMsg(String expErrorMsg){
		assertThat(getErrorMsg()).as("error messgae is: "+getErrorMsg()).isEqualTo(expErrorMsg);
	}
	public void setAdditionalDetails(String scenario,String additionalDetails,String popularity,String country,String certification,
			String year) {
		String newURL="";
		if(additionalDetails.equalsIgnoreCase("true")){
			switch(scenario.toLowerCase().trim()){					
			case "mostpopularmovies":
				newURL = getSavedEndPointUrl()+"&sort_by=popularity."+popularity+"&region="+country;
				saveEndPointUrl(newURL);
				break;
			case "highestratedmovies":	
				newURL = getSavedEndPointUrl()+"&sort_by=popularity."+popularity+"&certification="+certification;
				saveEndPointUrl(newURL);
				break;
			case "popularkidsmovies":
				newURL = getSavedEndPointUrl()+"&sort_by=popularity."+popularity+"&certification.lte="+certification;
				saveEndPointUrl(newURL);
				break;
			case "bestdramasinyear":
				newURL = getSavedEndPointUrl()+"&sort_by=popularity."+popularity+"&primary_release_year="+year;
				saveEndPointUrl(newURL);
				break;
			case"invalidapikey":
				newURL = getSavedEndPointUrl()+"123";
				saveEndPointUrl(newURL);
				break;	
			default: 
				setDetails();
				break;
			}
		}
	}

}
