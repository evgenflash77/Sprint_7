package list;

import io.qameta.allure.Description;
import org.junit.Test;
import steps.ListSteps;
import io.restassured.response.Response;

public class ListOrdersTest extends BaseApiTestList {

    @Test
    @Description("Проверка получения списка всех заказов. Ожидается статус 200 и корректная структура JSON.")
    public void testGetAllOrders() {

        Response response = ListSteps.getAllOrders();

        response.then().statusCode(200);
        ListSteps.checkListStructure(response);

        System.out.println("Тест прошел! Получено заказов: " + response.path("orders.size()"));
    }


}