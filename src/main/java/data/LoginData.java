package data;

import com.github.javafaker.Faker;

public class LoginData {
    static Faker user = new Faker();
    public static final String LOGIN = user.name().lastName() + System.currentTimeMillis();
    public static final String PASSWORD = user.regexify("[0-9]{4}");
    public static final String LOGIN_SYSTEM_AUTHORIZATION = "/api/v1/courier/login";
}
