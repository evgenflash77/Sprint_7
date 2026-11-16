package login;
import static data.CourierData.FIRSTNAME;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.equalTo;

import io.qameta.allure.Description;
import model.CourierModel;
import model.LoginModel;
import org.junit.After;

import org.junit.Test;

import static data.LoginData.LOGIN;
import static data.LoginData.PASSWORD;
import static steps.CourierSteps.createCourier;
import static steps.LoginSteps.systemLogin;

public class AuthorizationLoginTest extends  BaseApiTestLogin {
    @Test
    @Description("Проверка успешной авторизации курьера. Сначала регистрируем курьера, затем выполняем вход и проверяем наличие ID.")
    public void testAuthorizationLogin(){
        CourierModel courier = new CourierModel(LOGIN, PASSWORD, FIRSTNAME);
        createCourier(courier)
                .then()
                .statusCode(201)
                .body("ok", equalTo(true));

        LoginModel login = new LoginModel(LOGIN,PASSWORD);
        systemLogin(login)
                .then()
                .log().all()
                .statusCode(200)
                .body("id", instanceOf(Integer.class));
    }
    @After
    public void cleanup(){

    }
}

