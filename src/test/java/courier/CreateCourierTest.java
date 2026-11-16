package courier;


import io.qameta.allure.Description;
import io.restassured.response.Response;
import model.CourierModel;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static data.CourierData.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static steps.CourierSteps.createCourier;
import static steps.CourierSteps.deleteCourier;

public class CreateCourierTest extends BaseApiTestCourier {
    private String courierId;

    @Before
    public void setUp() {
        CourierModel courier = new CourierModel(LOGIN, PASSWORD, FIRSTNAME);
        Response response = createCourier(courier);
        response.then()
                .statusCode(201)
                .body("ok", equalTo(true));


        courierId = response.jsonPath().getString("id");
    }

    @Test
    @Description("Проверка успешного создания курьера. Ожидается статус 201 и поле ok=true.")
    public void testCreateCourier() {
        CourierModel courier = new CourierModel(LOGIN, PASSWORD, FIRSTNAME);

        createCourier(courier)
                .then()
                .log().all()
                .statusCode(201)
                .body("ok", equalTo(true));
    }

    @Test
    @Description("Проверка создания курьера без логина. Ожидается статус 400 и сообщение об ошибке.")
    public void testCreateCourierWithoutLogin() {
        CourierModel courier = new CourierModel(null, PASSWORD, FIRSTNAME);
        createCourier(courier)
                .then()
                .log().all()
                .statusCode(400)
                .body("message", equalTo("Недостаточно данных для создания учетной записи"));
    }


    @Test
    @Description("Проверка создания курьера без пароля. Ожидается статус 400 и сообщение об ошибке.")
    public void testCreateCourierWithoutPassword(){
        CourierModel courier = new CourierModel(LOGIN,null,FIRSTNAME);
        createCourier(courier)
                .then()
                .log().all()
                .statusCode(400)
                .body("message",equalTo("Недостаточно данных для создания учетной записи"));

    }

    @After
    public void cleanup() {
        if (courierId != null) {
            deleteCourier(courierId);
        }
    }
}
