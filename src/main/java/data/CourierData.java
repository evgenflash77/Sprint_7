package data;

import com.github.javafaker.Faker;

public class CourierData {
    static Faker user = new Faker();
    public static final String LOGIN = user.name().lastName() + System.currentTimeMillis();
    public static final String PASSWORD = user.regexify("[0-9]{4}");
    public static final String FIRSTNAME = "FIRSTNAME";
    public static final String COURIER_PEN_CREATE = "/api/v1/courier";
}
