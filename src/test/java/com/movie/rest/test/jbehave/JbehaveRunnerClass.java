package com.movie.rest.test.jbehave;

import net.serenitybdd.jbehave.SerenityStories;

public class JbehaveRunnerClass extends SerenityStories{
 @Override
 public void findStoriesCalled(String storyNames) {
	super.findStoriesCalled("movieSearch.story");
 }
}
