package model;
import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
public class OrderModel {
    private String  firstName;
    private String lastName;
    private String address;
    private String metroStation;
    private String phone;
    private int rentTime;
    private String deliveryDate;
    private String comment;
    private List<String> color;
}
