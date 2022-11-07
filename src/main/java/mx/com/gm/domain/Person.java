package mx.com.gm.domain;
//Creo una clase de entidad llamada Person, utilzo para la conexión con la bbdd JPA bajo la implementación de
// hibernate, es capa datos

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
@Data
@Entity//Convierto la clase a clase de entidad
@Table(name = "person")//así corrijo el nombre de mi tabla de mi bbdd, para que no haya problemas con mayúsculas y minúsculas
public class Person implements Serializable {//la clase implementa la interface de Serializable

    private static final long serialVersionUID = 1L; //atributo para implementar la interface Serializable

    //agrego el mapeo de la llave primaria idPerson:
    @Id // indico cual es el campo de mi llave primaria de mi clase de entidad
    @GeneratedValue(strategy = GenerationType.IDENTITY) //indico forma de generar esa llave primaria
    private Long idPerson;
    //mapeo del resto de columnas de mi tabla:
    private String  name;
    private String  surname;
    private String  email;
    private String  phone;
}
