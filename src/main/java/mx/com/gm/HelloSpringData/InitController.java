package mx.com.gm.HelloSpringData;

import lombok.extern.slf4j.Slf4j;
import mx.com.gm.HelloSpringData.domain.Person;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;

@Controller
@Slf4j
public class InitController {
    @Value("${index.greeting}") //Ojo esta notación es la de springframework, no la de lombok
    private String greeting;//Así Spring aplica el concepto de inyección de dependencias

    //Método (ya no tiene que ver con application properties):
    @GetMapping("/")

    public String  init(Model model){//vamos a recibir un objeto tipo Model. Con la clase Model voy a agregar la info
        // que quiero compartir con la vista

        //Inicio una variable local:
        var message = "Hello World with Thymeleaf";//es la variable que voy a compartir utilizando la clase Model

        var person = new Person();//Para instanciar la clase person
        person.setName("Juan");//meto los valores para crear la variable persona y poder compartirla usando la clase model
        person.setSurname("Perez");
        person.setEmail("jperez@mail.com");
        person.setPhone("5544332211");

        var person2 = new Person();//Para instanciar la clase person
        person2.setName("Karla");//meto los valores para crear la variable persona y poder compartirla usando la clase model
        person2.setSurname("Gomez");
        person2.setEmail("kgomez@mail.com");
        person2.setPhone("357321456");

        /*
       // List<Person> persons =new ArrayList<>();//Creo un array para que contenga mis objetos de tipo Person, puedo hacerlo así o con var:
        var persons =new ArrayList<>();
        persons.add(person);
        persons.add(person2);
         */

        //O también puedo hacerlo así:
        var persons = Arrays.asList(person, person2);

        //var persons = new ArrayList<>();//si quiero mandar una lista vacíapara probar la vista

        log.info("ejecutanto el controlador Spring MVC");  //Esto puedo hacerlo gracias a la notación de manejo de
        // logging.Me imprime en terminal este mensaje cuando se ejecuta el controlador

        model.addAttribute("message", message); //utilizo la clase de modelo(que es un mapa) para compartir la variable
        // message, y el método al ser un mapa, lleva el String y el objeto: "llave" y valor

        //También puedo agregar un mensaje en application properties:
        model.addAttribute("greeting", greeting);//ahora debo ir a la vista, index, y desplegar esta información

        //Para compartir la variable person usando mi clase Model:
        model.addAttribute("person", person); //llave person, objeto person que creé arriba al instanciar
        // la clase Person. AHora ya voy a la vista

        //Para compartir la lista de objetos de tipo Person:
        model.addAttribute("persons", persons );

        return "Index"; //ESTE ARCHIVO ES MI VISTA, DESDE DONDE VOY A LLAMAR A LAS
        // VARIABLES DE ESTE CONTROLADOR, EL MODELO LO PONE SPRING EN AUTOMÁTICO

    }
}
