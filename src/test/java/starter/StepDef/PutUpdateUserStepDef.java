package starter.StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Reqres.ReqresAPI;
import starter.Reqres.ReqresResponses;
import starter.Utils.Constants;


import java.io.File;
import static org.hamcrest.Matchers.equalTo;

public class PutUpdateUserStepDef {

    @Steps
    ReqresAPI reqresAPI;

    // PUT Update
    @Given("Put update user with valid json and id {int}")
    public void putUpdateUserWithValidJsonAndId(int id) {
        File json = new File(Constants.JSON_REQUEST_UPDATE_USER+"RequestUpdateUser_1.json");
        reqresAPI.putUpdateUser(id, json);
    }

    @When("Send put update user")
    public void sendPutUpdateUser() {
        SerenityRest.when().put(ReqresAPI.PUT_UPDATE_USER);
    }

    @And("Response body name {string} and job {string}")
    public void responseBodyNameAndJob(String name, String job) {
        SerenityRest.and()
                .body(ReqresResponses.NAME, equalTo(name))
                .body(ReqresResponses.JOB,equalTo (job));
    }

    @And("Validate put create user JSON Schema validator")
    public void validatePutCreateUserJSONSchemaValidator() {
        File json = new File(Constants.JSON_SCHEMA_CREATE_USER+"UpdateUserJSONSchema.json");
        SerenityRest.and().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
