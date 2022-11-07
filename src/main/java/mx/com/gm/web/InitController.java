package mx.com.gm.web;
//He movido esta clase al paquete web, en lugar de tenerlo en HelloSpringData
//Esta es la capa presentación, con thymeleaf y modelo MVC
import lombok.extern.slf4j.Slf4j;
import mx.com.gm.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class InitController {

    //Para inyectar aquí la interface cuando no tengo capa de servicio:
    //@Autowired //para poder inyectar la interface y asi ya tengo todos los métodos del crud para el objeto tipo Person
    //private PersonDAO personDAO;

    //Para inyectar la capa de servicio cuando la tengo:
    @Autowired
    private PersonService personService;

    @GetMapping("/")

    public String  init(Model model){

        //Para recuperar lo objetos de tipo Person:
        var persons = personService.readPersons();//justo aquí es cuando se hace la implementación de mi clase PersonDAO

        log.info("ejecutando el controlador Spring MVC");
        model.addAttribute("persons", persons); //comparto la variable persons (listado de persons)
        return "index";
    }
}

