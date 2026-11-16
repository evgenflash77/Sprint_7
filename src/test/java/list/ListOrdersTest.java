package list;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;
import steps.ListSteps;
import io.restassured.response.Response;

public class ListOrdersTest {

    @Before
    public void setUp() {

        RestAssured.baseURI = "https://qa-scooter.praktikum-services.ru";
    }

    @Test
    @Description("Проверка получения списка всех заказов. Ожидается статус 200 и корректная структура JSON.")
    public void testGetAllOrders() {

        Response response = ListSteps.getAllOrders();

        response.then().statusCode(200);
        ListSteps.checkListStructure(response);

        System.out.println("Тест прошел! Получено заказов: " + response.path("orders.size()"));
    }


}