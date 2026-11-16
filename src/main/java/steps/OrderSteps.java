package steps;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import model.OrderModel;

import static data.OrderData.ORDER_CREATE;
import static io.restassured.RestAssured.given;

public class OrderSteps {
    @Step("Создать заказ: colors={order.color}")
    public static Response createOrder(OrderModel order){
        return
                given()
                        .log().all()
                        .contentType(ContentType.JSON)
                        .body(order)
                        .post(ORDER_CREATE)
                        .then()
                        .extract().response();
    }
}
