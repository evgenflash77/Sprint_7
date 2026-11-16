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

public class AuthorizationWithWrongPasswordTest extends BaseApiTestLogin{
    @Test
    @Description("Проверка обработки входа с неверным паролем. Сначала регистрируем курьера, затем пытаемся войти с неправильным паролем. Ожидается статус 404.")
    public void testеAuthorizationWithWrongLogin(){
        CourierModel courier = new CourierModel(LOGIN, PASSWORD, FIRSTNAME);
        createCourier(courier)
                .then()
                .statusCode(201)
                .body("ok", equalTo(true));
        LoginModel login = new LoginModel(LOGIN,"58901345");
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

