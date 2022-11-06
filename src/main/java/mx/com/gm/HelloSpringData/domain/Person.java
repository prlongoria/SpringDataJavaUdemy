package mx.com.gm.HelloSpringData.domain;

import lombok.Data;

@Data
public class Person {
    private String  name;
    private String  surname;
    private String  email;
    private String  phone;
}
