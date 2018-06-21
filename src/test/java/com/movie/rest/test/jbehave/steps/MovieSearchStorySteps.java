package com.movie.rest.test.jbehave.steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import com.movie.rest.test.steps.MovieSearchSteps;
import com.movie.rest.test.util.Util;

import net.thucydides.core.annotations.Steps;

public class MovieSearchStorySteps {
	
	@Steps
	MovieSearchSteps mss;
	
	@Given("set the data to request")
	public void setDetails(){
		mss.setDetails();
	}
	
	@Given("set additional search options to request")
	public void setAdditionalParms(@Named("Scenario") String scenario,@Named("AdditionalDetails") String additionalDetails,
			@Named("Popularity") String popularity,@Named("Country") String country,
			@Named("Cert")String certification,@Named("Year") String year){
		mss.setAdditionalDetails(scenario,additionalDetails,Util.isStoryNull(popularity) ? null : popularity,
				Util.isStoryNull(country)? null : country,Util.isStoryNull(certification)? null : certification,
			    Util.isStoryNull(year)? null : year);
	}
	@When("request is executed")
	public void executReq(){
		mss.whenRequestExecuted();
	}
	@Then("verify the response")
	public void verifyResponse(@Named("httpsCode") String hs){
		mss.verifyResponse(hs);
	}
	
	@Then("verify error message")
	public void verifyErrorMessage(@Named("errorMessage") String expErrorMsg){
		mss.verifyErrorMsg(expErrorMsg);
	}

}
