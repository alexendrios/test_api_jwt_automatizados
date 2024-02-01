package tests.test.request;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class TestRequest {

    @Step("Teste Verificar se a aplicação está no ar - GET")
    public Response test(String path) {
        return given()
                .contentType(ContentType.JSON)
                .when()
                .get(path);
    }
}