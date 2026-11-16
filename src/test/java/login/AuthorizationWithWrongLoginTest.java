package login;

import io.qameta.allure.Description;
import model.CourierModel;
import model.LoginModel;
import org.hamcrest.CoreMatchers;
import org.junit.After;

import org.junit.Test;

import static data.CourierData.FIRSTNAME;
import static data.LoginData.LOGIN;
import static data.LoginData.PASSWORD;
import static org.hamcrest.Matchers.equalTo;
import static steps.CourierSteps.createCourier;
import static steps.LoginSteps.systemLogin;

public class AuthorizationWithWrongLoginTest extends BaseApiTestLogin {
    @Test
    @Description("Проверка обработки входа с неверным логином. Сначала регистрируем курьера, затем пытаемся войти с неправильным логином. Ожидается статус 404.")
    public void testAuthorizationWithWrongLogin(){
            CourierModel courier = new CourierModel(LOGIN, PASSWORD, FIRSTNAME);
            createCourier(courier)
                    .then()
                    .statusCode(201)
                    .body("ok", equalTo(true));

        LoginModel login = new LoginModel("ПАвеЛЛ",PASSWORD);
        systemLogin(login)
                .then()
                .log().all()
                .statusCode(404)
                .body("message", CoreMatchers.equalTo("Учетная запись не найдена"));
    }

     @After
      public void cleanup(){

   }
}

