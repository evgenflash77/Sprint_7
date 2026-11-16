package courier;
import io.qameta.allure.Description;
import model.CourierModel;
import org.junit.After;
import org.junit.Test;

import static data.CourierData.FIRSTNAME;
import static data.CourierData.PASSWORD;
import static org.hamcrest.CoreMatchers.equalTo;
import static steps.CourierSteps.createCourier;


public class CreateCourierWithoutLoginTest extends BaseApiTestCourier {

    @Test
    @Description("Проверка создания курьера без логина. Ожидается статус 400 и сообщение об ошибке.")
    public void testCreateCourierWithoutLogin(){
        CourierModel courier = new CourierModel(null,PASSWORD,FIRSTNAME);
        createCourier(courier)
                .then()
                .log().all()
                .statusCode(400)
                .body("message",equalTo("Недостаточно данных для создания учетной записи"));

    }
    @After
    public void cleanup(){

    }

}
