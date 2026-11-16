package courier;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import model.CourierModel;

import org.junit.Test;

import static data.CourierData.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static steps.CourierSteps.createCourier;

@DisplayName("Группа: Курьеры")
public class CreateCourierDuplicateTest extends BaseApiTestCourier {



    @Test
    @DisplayName("Дубликат курьера")
    @Description("Создаем курьера, потом пробуем снова. Должна быть ошибка 409")
    public void testCreateDuplicateCourier() {

        CourierModel courier = new CourierModel(LOGIN, PASSWORD, FIRSTNAME);

        createCourier(courier)
                .then()
                .log().all()
                .statusCode(201)
                .body("ok", equalTo(true));

        createCourier(courier)
                .then()
                .log().all()
                .statusCode(409)
                .body("message", equalTo("Этот логин уже используется. Попробуйте другой."));
    }
}