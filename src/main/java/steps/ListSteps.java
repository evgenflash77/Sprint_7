package steps;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import static data.ListData.GET_LIST;
import static io.restassured.RestAssured.given;

public class ListSteps {

    @Step("Получить список всех заказов")
    public static Response getAllOrders() {
        return given()
                .log().all()
                .when()
                .get(GET_LIST)
                .then()
                .statusCode(200)
                .extract().response();
    }


    public static Response getOrdersByCourier(int courierId) {
        return given()
                .log().all()
                .queryParam("courierId", courierId)
                .when()
                .get(GET_LIST)
                .then()
                .extract().response();
    }

    public static void checkListStructure(Response response) {
        response.then()
                .body("orders", Matchers.notNullValue())
                .body("pageInfo", Matchers.notNullValue())
                .body("pageInfo.total", Matchers.notNullValue());
    }

}