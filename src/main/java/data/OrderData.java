package data;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class OrderData {
    static Faker user = new Faker();
    public static final String FIRSTNAME = user.name().firstName()+ System.currentTimeMillis();
    public static final String LASTNAME = user.name().lastName()+ System.currentTimeMillis();
    public static final String ADDRESS = user.address().fullAddress() ;
    public static final String METRO_STATION = user.regexify("[0-9]{3}");
    public static final String PHONE = user.phoneNumber().phoneNumber();
    public static final String COMMENT = user.lorem().sentence(5);
    public static final int RENT_TIME = ThreadLocalRandom.current().nextInt(1, 7);
    public static final String DELIVERY_DATE = LocalDate.now()
            .plusDays(user.number().numberBetween(1, 30))
            .format(DateTimeFormatter.ISO_LOCAL_DATE);
    public static final String ORDER_CREATE = "/api/v1/orders";
    public static final List<String> COLOR = List.of("BLACK", "GREY");
}
