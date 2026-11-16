package steps;
import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import model.LoginModel;
import static data.LoginData.LOGIN_SYSTEM_AUTHORIZATION;
import static io.restassured.RestAssured.given;

public class LoginSteps {
    @Step("Авторизовать пользователя: login={login.login}")
    public static Response systemLogin(LoginModel login){
        return
                given()
                        .log().all()
                        .contentType(ContentType.JSON)
                        .body(login)
                        .post(LOGIN_SYSTEM_AUTHORIZATION)
                        .then()
                        .extract().response();
    }
}
