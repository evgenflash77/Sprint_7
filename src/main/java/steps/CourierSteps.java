package steps;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import model.CourierModel;
import static data.CourierData.COURIER_DELETE;
import static data.CourierData.COURIER_PEN_CREATE;
import static io.restassured.RestAssured.given;

public class    CourierSteps  {
    @Step("Создать курьера: login={courier.login}, password=***")
    public static Response createCourier(CourierModel courier){
        return
                given()
                        .log().all()
                        .contentType(ContentType.JSON)
                        .body(courier)
                        .when()
                        .post(COURIER_PEN_CREATE)
                        .then()
                        .extract().response();

    }

    @Step("Удалить курьера с id={id}")
    public static Response deleteCourier(String id){
        return
                given()
                        .log().all()
                        .delete(COURIER_DELETE + "/" + id);

    }


}
