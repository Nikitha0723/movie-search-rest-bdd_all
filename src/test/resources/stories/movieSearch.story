Story: MovieSearch
Meta:
@author Nikitha
Narrative:
In order to search for movie details
As a user 
I want to verify movie database api

Scenario: Verify User able to search for movie details
Meta:
@happyPath
Given set the data to request
And set additional search options to request
When request is executed
Then verify the response
Examples:
|Scenario          |AdditionalDetails|Popularity|Country|Cert  |Year  |httpsCode|
|all Movies        |false            |          |       |      |<null>|200      |
|MostPopularMovies |true             |desc      |IN     |      |<null>|200      |
|HighestRatedMovie |true             |desc      |       |R     |<null>|200      |
|PopularKidsMovies |true             |desc      |       |G     |<null>|200      |
|BestDramasInYear  |true             |desc      |       |      |2017  |200      |

 
Scenario: Verify when user passing invalid API KEY
Meta:
@errorPath
Given set the data to request

And set additional search options to request
When request is executed
Then verify the response
And verify error message
Examples:
|Scenario          |AdditionalDetails|Popularity|Country|Cert  |Year  |httpsCode|errorMessage|
|InvalidApiKey     |true             |          |       |      |<null>|401      |Invalid API key: You must be granted a valid key.|