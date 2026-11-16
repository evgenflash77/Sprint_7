package Order;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import model.OrderModel;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import steps.OrderSteps;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static data.OrderData.*;


@RunWith(Parameterized.class)
public class CreateOrderTest {

    @Before
    public void setUp() {

        RestAssured.baseURI = "https://qa-scooter.praktikum-services.ru";
    }

    @Parameterized.Parameter(0)
    public List<String> color;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { List.of("BLACK") },
                { List.of("GREY") },
                { List.of("BLACK", "GREY") },
                { null }
        });
    }

    @Test
    @Description("Создание заказа с различными вариантами цвета (черный, серый, оба, отсутствие цвета). Ожидается статус 201 и наличие номера трека (track).")
    public void createOrder() {
        OrderModel order = new OrderModel(
                FIRSTNAME, LASTNAME, ADDRESS, METRO_STATION,
                PHONE, RENT_TIME, DELIVERY_DATE, COMMENT,
                color
        );


        OrderSteps.createOrder(order).then()
                .statusCode(201)
                .body("track", Matchers.notNullValue());
    }
    @After
    public void cleanup(){

    }
} 