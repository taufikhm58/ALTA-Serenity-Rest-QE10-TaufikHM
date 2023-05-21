package starter.StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Reqres.ReqresAPI;
import starter.Reqres.ReqresResponses;
import starter.Utils.Constants;


import java.io.File;
import static org.hamcrest.Matchers.equalTo;

public class PostCreateUserStepDef {

    @Steps
    ReqresAPI reqresAPI;

    //    POST Create New User
    @Given("Post create user with valid json")
    public void postCreateUserWithValidJson() {
        File json = new File(Constants.JSON_REQUEST_CREATE_USER+"RequestCreateUser.json");
        reqresAPI.postCreateUser(json);
    }

    @When("Send post create user")
    public void sendPostCreateUserFeature() {
        SerenityRest.when().post(ReqresAPI.POST_CREATE_USER);
    }

    @Then("Status code should be {int} Created")
    public void statusCodeShouldBeCreated(int created) {
        SerenityRest.then().statusCode(created);
    }

    @And("Response body name was {string} and job was {string}")
    public void responseBodyNameWasAndJobWas(String name, String job) {
        SerenityRest.and()
                .body(ReqresResponses.NAME, equalTo(name))
                .body(ReqresResponses.JOB,equalTo (job));
    }
    @And("validate post create user JSON Schema validator")
    public void validatePostCreateUserJSONSchemaValidator() {
        File json = new File(Constants.JSON_SCHEMA_CREATE_USER+"CreateUserSchema.json");
        SerenityRest.and().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

}
