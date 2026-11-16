package login;

import io.qameta.allure.Description;
import model.LoginModel;
import org.junit.After;
import org.junit.Test;

import static data.LoginData.PASSWORD;
import static org.hamcrest.CoreMatchers.equalTo;
import static steps.LoginSteps.systemLogin;

public class AuthorizationLoginWithoutLoginTest extends BaseApiTestLogin{
    @Test
    @Description("Проверка обработки попытки входа без логина. Ожидается статус 400 и сообщение об ошибке.")
    public void testAuthorizationLoginWithoutLogin(){
        LoginModel login = new LoginModel(null,PASSWORD);
        systemLogin(login)
                .then()
                .log().all()
                .statusCode(400)
                .body("message",equalTo("Недостаточно данных для входа"));
    }
    @After
    public void cleanup(){

    }
}
