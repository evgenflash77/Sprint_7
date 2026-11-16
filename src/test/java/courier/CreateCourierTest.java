package courier;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import model.CourierModel;
import org.junit.After;
import org.junit.Test;
import static data.CourierData.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static steps.CourierSteps.createCourier;

public class CreateCourierTest extends BaseApiTestCourier {
    @Test
    @Description("Проверка успешного создания курьера. Ожидается статус 201 и поле ok=true.")
    public void testCreateCourier(){
        CourierModel courier = new CourierModel(LOGIN ,PASSWORD,FIRSTNAME);

        createCourier(courier)
                .then()
                .log().all()
                .statusCode(201)
                .body("ok", equalTo(true));


    }

    @After
    public void cleanup(){

    }

}
