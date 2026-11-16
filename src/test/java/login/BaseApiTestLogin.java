package login;

import io.restassured.RestAssured;
import org.junit.Before;

public class BaseApiTestLogin {
    @Before
    public void setup(){
        RestAssured.baseURI = "https://qa-scooter.praktikum-services.ru/";

    }
}
