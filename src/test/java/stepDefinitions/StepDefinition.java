package stepDefinitions;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.hamcrest.Matchers.equalTo;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import static org.hamcrest.Matchers.containsInAnyOrder;

public class StepDefinition {
	private Response response;
	private ValidatableResponse json;
	private RequestSpecification request;
    private String ENDPOINT_GET_BOOK_BY_ISBN = "https://www.googleapis.com/books/v1/volumes";

    @Given("a book exists with an isbn of {int}")
    public void a_book_exists_with_an_isbn_of(Integer int1) {  
    	System.out.println("Hello");
    
    	request = request.given().param("q", "isbn:" + int1);
    }

    @When("^a user retrieves the book by isbn$")
    public void a_user_retrieves_the_book_by_isbn() throws Throwable {
    	response = request.when().get(ENDPOINT_GET_BOOK_BY_ISBN);
		System.out.println("response: " + response.prettyPrint());
    }

    @Then("^the status code is 200$")
    public void the_status_code_is_200(int statusCode) throws Throwable {
    	json = response.then().statusCode(statusCode);
    }

    @And("^response includes the following$")
    public void  response_equals(Map<String,String> responseFields) {
    	for (Map.Entry<String, String> field : responseFields.entrySet()) {
			if(StringUtils.isNumeric(field.getValue())){
				json.body(field.getKey(), equalTo(Integer.parseInt(field.getValue())));
			}
			else{
				json.body(field.getKey(), equalTo(field.getValue()));
			}
		}
	}
	
    

    @And("^response includes the following in any order$")
    public void response_contains_in_any_order(Map<String,String> responseFields){
		for (Map.Entry<String, String> field : responseFields.entrySet()) {
			if(StringUtils.isNumeric(field.getValue())){
				json.body(field.getKey(), containsInAnyOrder(Integer.parseInt(field.getValue())));
			}
			else{
				json.body(field.getKey(), containsInAnyOrder(field.getValue()));
			}
		}

	
	
    }
}