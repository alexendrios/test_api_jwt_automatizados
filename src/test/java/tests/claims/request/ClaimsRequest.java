package tests.claims.request;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;

import static io.restassured.RestAssured.given;

@Slf4j
@Feature("Claims")
@Owner("ITAU")
public class ClaimsRequest {

    @Step("Realizar cadastro de um Clain  - POST")
    public Response cadastroClaim(String path, String dados) {
        return given()
                .body(dados)
                .contentType(ContentType.JSON)
                .when()
                .post(path);
    }
}
